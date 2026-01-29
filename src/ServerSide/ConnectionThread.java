/**
 * BY: Sanjay Suthakaran
 * Date: March 29, 2024
 *
 * Class Desc: This is the thread class to which the server redirects pairs of players for the game.
 * This class also contains the main logic and workings of the game itself, and will communicate with the terminal/GUI clients.
 *
 */

package ServerSide;

import java.io.*;
import java.net.*;

public class ConnectionThread extends Thread{
    private Socket client1,client2;

    private char[][] board = { //the actual game board
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'},
            {'-','-','-','-','-','-','-'}};

    private int[] columnFreeSpace = {5,5,5,5,5,5,5}; //how many free space per col (is 0 indexed)

    public ConnectionThread(Socket c1, Socket c2) {
        client1=c1; client2=c2;
    }

    public void run() {

        try (
                PrintWriter out1 = new PrintWriter(client1.getOutputStream(), true);
                PrintWriter out2 = new PrintWriter(client2.getOutputStream(), true);
                BufferedReader in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
                BufferedReader in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));

        ) {

            String inputLine;

            //tell each player who is who
            out1.println("You are player 1");
            out2.println("You are player 2");


            while (true) {

                //PLAYER 1 TURN--------------------------------------------------------------
                out1.println("It is your turn. Enter a number for column 1-7.");
                inputLine = userInput(in1, out1); //send user's input to userInput function for examination
                if (inputLine.equals("0")) break;


                insert(Integer.valueOf(inputLine)-1, 1);

                serverMessage(printBoard(),out1,out2); //print board on each turn


                //CHECK IF PLAYER 1 WIN
                if (horizontalWinner('X') || verticalWinner('X') || diagonalWinner('X')) {
                    serverMessage("PLAYER 1 WINS!! Hope you had a good game.",out1,out2);
                    break;
                }
                //--------------------------------------------------------------------------


                //PLAYER 2 TURN-------------------------------------------------------------
                out2.println("It is your turn. Enter a number for column 1-7.");
                inputLine = userInput(in2, out2); //send user's input to userInput function for examination
                if (inputLine==null) break;

                insert(Integer.valueOf(inputLine)-1, 2);

                serverMessage(printBoard(),out1,out2); //print board on each turn

                //CHECK IF PLAYER 2 WIN
                if (horizontalWinner('O') || verticalWinner('O') || diagonalWinner('O')) {
                    serverMessage("PLAYER 2 WINS!! Hope you had a good game.",out1,out2);
                    break;
                }
                //--------------------------------------------------------------------------


            }

        } catch (IOException e) {
            System.out.println("Ah nertz.");
        }
    }


    /**
     * This helper method allows the server to send a message to both clients at the same time.
     * @param message - the message to be sent
     * @param client1 - client 1
     * @param client2 - client 2
     */
    private void serverMessage(String message, PrintWriter client1, PrintWriter client2){
        client1.println(message);
        client2.println(message);
    }

    /**
     * This method simply iterates through the 2D board array and concatenates the board into a string.
     * @return - returns the string containing the board (formatted)
     */
    private String printBoard(){
        String boardString = "";

        for (int i = 0; i < board.length; i++){

            for (int j = 0; j < board[i].length; j++){

                boardString = boardString + ' ' + board[i][j];

            }
            boardString = boardString + "\n";
        }
        return boardString;
    }


    /**
     * This method inserts an 'X' or 'O' onto the board depending on the coordinate given.
     * @param xValue - X - Coordinate
     * @param player - to determine if we insert an 'X' or 'O'
     */
    private void insert(int xValue, int player){

        if (player == 1){
            board[columnFreeSpace[xValue]][xValue] = 'X';
        }
        else{
            board[columnFreeSpace[xValue]][xValue] = 'O';
        }

        //decrement the column space count that we just added to
        columnFreeSpace[xValue]  = columnFreeSpace[xValue] -1;

    }


    /**
     * This method takes in the user's input and determines if it is valid. It will loop until we get a valid input.
     * @param currentPlayer - the player sending the input
     * @param outputPlayer - the player to send an error message to (if needed)
     * @return - the valid user input
     * @throws IOException
     */
    private String userInput(BufferedReader currentPlayer, PrintWriter outputPlayer) throws IOException {

        String input;

        while (true){

            input = currentPlayer.readLine();

            if (input==null) return "0";

            if (inputIsInteger(input) == true) { //first, check if user does input an int

                if (Integer.valueOf(input) > 0 && Integer.valueOf(input) < 8){ //next, check if valid column (if it exists)

                    if (columnFreeSpace[Integer.valueOf(input) - 1] != -1 ){ //next, check if that column is full

                        break; //if all 3 met, valid input
                    }
                    outputPlayer.println("That column is full! Please pick a different column (1-7). ");
                }

                else{
                    outputPlayer.println("This is not a valid column number! Please try again, (1-7). ");
                }

            }
            else{
                outputPlayer.println("Incorrect input! Please enter the number of the column (1-7) you want to go with!  ");
            }

        }

        return input;

    }


    /**
     * Helper method to check if the user inputted an integer or not.
     * @param input - input to be checked
     * @return - true/false
     */
    private boolean inputIsInteger(String input){
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }


    /**
     * This method checks if we have 4 in a row, horizonally.
     * This is done by incrementing a counter for each time we have an X/O in a row, and setting it to 0 if we get something else.
     * @param check - the char (X or O) we want to check for
     * @return - true/false
     */
    private boolean horizontalWinner(char check){
        int counter = 0;

        for (int i = 0; i < board.length; i++){

            for (int j = 0; j < board[i].length; j++){

                if (check == board[i][j]){
                    counter++;

                    if (counter == 4){
                        return true;
                    }
                }
                else{
                    counter = 0;
                }

            }
            counter = 0;
        }

        //if none
        return false;
    }


    /**
     * This method checks if we have 4 in a row, vertically.
     * This is done by incrementing a counter for each time we have an X in a column, and setting it to 0 if we get something else.
     * @param check - the char (X or O) we want to check for
     * @return - true/false
     */
    private boolean verticalWinner(char check){
        int counter = 0;
        for (int i = 0; i < board[0].length; i++){

            for (int j = 0; j < board.length; j++){

                if (check == board[j][i]){
                    counter++;

                    if (counter == 4){
                        return true;
                    }
                }
                else{
                    counter = 0;
                }
            }
            counter = 0;

        }

        //if none
        return false;
    }


    /**
     * This method checks if we have 4 in a row diagonally to the left or right.
     * This is done with an algorithm where we start with the first diagonal and iterate it through the entire array to see if any X/O's line up
     * @param check - the char (X or O) we want to check for
     * @return - true/false
     */
    private boolean diagonalWinner(char check){

        //left to right diagonal
        for (int s = 3; s < board.length; s++) {
            for (int j = 0; j < board[0].length - 3 ; j++) {

                if (board[s][j] == check && board[s-1][j+1] == check && board[s-2][j+2] == check && board[s-3][j+3] == check){
                    return true;
                }

            }
        }

        //Right to left diagonal
        for (int d = 0; d < board.length -3; d++) {
            for (int j = 0; j < board[0].length - 3 ; j++) {
                if (board[d][j] == check && board[d+1][j+1] == check && board[d+2][j+2] == check && board[d+3][j+3] == check){
                    return true;
                }

            }
        }

        //if none
        return false;
    }

}
