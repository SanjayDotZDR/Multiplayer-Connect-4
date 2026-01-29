/**
 * BY: Sanjay Suthakaran
 * Date: March 29, 2024
 *
 * Class Desc: This is the client class; it works together with the GUIWindow class to provide a GUI client for the Connect 4 game.
 *
 */

package ClientSide;

import java.io.*;
import java.net.*;

public class Client  {

    public static void main(String[] args) {
        String hostName="localhost";
        int portNumber=1024;
        try (
                Socket conn=new Socket(hostName, portNumber);
                PrintWriter sockOut=new PrintWriter(conn.getOutputStream(),true);
                BufferedReader sockIn=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                //Scanner termIn=new Scanner(System.in);
        ) {

            String playerNum =sockIn.readLine();

            //initialize GUI window
            GUIWindow window = new GUIWindow(sockOut, playerNum.substring(playerNum.length() -1));

            //this string keeps track of the game board being sent from the server in text format and collects the string
            //this is because I found the loop runs quicker than the board being sent; resulting in pieces arriving one at a time.
            String serverBoard = "";

            window.displayMessage("Other Player's turn...");

            while (true) {

                String fromServer=sockIn.readLine(); //read from server
                window.displayMessage(fromServer);

                if (fromServer.contains("WINS")){ //exit loop if some player wins
                    break;
                }

                if (serverBoard.length() == 84){ //full connect 4 board from server has arrived

                    window.updateBoard(serverBoard.replace(" ",""));
                    serverBoard = ""; //reset string

                    window.displayMessage("Other Player's turn...");

                }

                if (fromServer.contains("1-7")){ //if GUI player's turn (we know this because the string contains '1-7' which is in ALL string prompts for the player's turn.

                    window.myTurn = true;

                }
                else{ //collect the strings printed from the server for the updated board
                    serverBoard = serverBoard + fromServer;

                }

            }


        } catch (UnknownHostException e) {
            System.out.println("I think there's a problem with the host name.");
        } catch (IOException e) {
            System.out.println("Had an IO error for the connection.");
        }

    }

}






