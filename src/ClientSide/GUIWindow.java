/**
 * BY: Sanjay Suthakaran
 * Date: March 29, 2024
 *
 * Class Desc: This is the GUIWindow class, which creates all the things the player will see in the GUI.
 *
 */

package ClientSide;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.*;

public class GUIWindow extends JFrame implements ActionListener {

    //buttons
    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public JButton button5;
    public JButton button6;
    public JButton button7;

    JLabel message;
    boolean myTurn = false; //this allows the button to work ONLY when it is the user's turn.
    PrintWriter sockOut;
    JPanel[][] panelArr; //2D array containing JPanels, corresponding to each tile on the board.
    String playerNum;

    GUIWindow(PrintWriter sockOut, String playerNum){

        this.playerNum = playerNum;
        this.sockOut = sockOut;

        //ROW1-----------------------------------------------
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.black);
        panel1.setBounds(110,100,80,80);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.black);
        panel2.setBounds(190,100,80,80);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.black);
        panel3.setBounds(270,100,80,80);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.black);
        panel4.setBounds(350,100,80,80);

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.black);
        panel5.setBounds(430,100,80,80);

        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.black);
        panel6.setBounds(510,100,80,80);

        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.black);
        panel7.setBounds(590,100,80,80);

        //ROW2-----------------------------------------------
        JPanel panel8 = new JPanel();
        panel8.setBackground(Color.black);
        panel8.setBounds(110,180,80,80);

        JPanel panel9 = new JPanel();
        panel9.setBackground(Color.black);
        panel9.setBounds(190,180,80,80);

        JPanel panel10 = new JPanel();
        panel10.setBackground(Color.black);
        panel10.setBounds(270,180,80,80);

        JPanel panel11 = new JPanel();
        panel11.setBackground(Color.black);
        panel11.setBounds(350,180,80,80);

        JPanel panel12 = new JPanel();
        panel12.setBackground(Color.black);
        panel12.setBounds(430,180,80,80);

        JPanel panel13 = new JPanel();
        panel13.setBackground(Color.black);
        panel13.setBounds(510,180,80,80);

        JPanel panel14 = new JPanel();
        panel14.setBackground(Color.black);
        panel14.setBounds(590,180,80,80);

        //ROW3-----------------------------------------------
        JPanel panel15 = new JPanel();
        panel15.setBackground(Color.black);
        panel15.setBounds(110,260,80,80);

        JPanel panel16 = new JPanel();
        panel16.setBackground(Color.black);
        panel16.setBounds(190,260,80,80);

        JPanel panel17 = new JPanel();
        panel17.setBackground(Color.black);
        panel17.setBounds(270,260,80,80);

        JPanel panel18 = new JPanel();
        panel18.setBackground(Color.black);
        panel18.setBounds(350,260,80,80);

        JPanel panel19 = new JPanel();
        panel19.setBackground(Color.black);
        panel19.setBounds(430,260,80,80);

        JPanel panel20 = new JPanel();
        panel20.setBackground(Color.black);
        panel20.setBounds(510,260,80,80);

        JPanel panel21 = new JPanel();
        panel21.setBackground(Color.black);
        panel21.setBounds(590,260,80,80);

        //ROW4-----------------------------------------------
        JPanel panel22 = new JPanel();
        panel22.setBackground(Color.black);
        panel22.setBounds(110,340,80,80);

        JPanel panel23 = new JPanel();
        panel23.setBackground(Color.black);
        panel23.setBounds(190,340,80,80);

        JPanel panel24 = new JPanel();
        panel24.setBackground(Color.black);
        panel24.setBounds(270,340,80,80);

        JPanel panel25 = new JPanel();
        panel25.setBackground(Color.black);
        panel25.setBounds(350,340,80,80);

        JPanel panel26 = new JPanel();
        panel26.setBackground(Color.black);
        panel26.setBounds(430,340,80,80);

        JPanel panel27 = new JPanel();
        panel27.setBackground(Color.black);
        panel27.setBounds(510,340,80,80);

        JPanel panel28 = new JPanel();
        panel28.setBackground(Color.black);
        panel28.setBounds(590,340,80,80);

        //ROW5-----------------------------------------------
        JPanel panel29 = new JPanel();
        panel29.setBackground(Color.black);
        panel29.setBounds(110,420,80,80);

        JPanel panel30 = new JPanel();
        panel30.setBackground(Color.black);
        panel30.setBounds(190,420,80,80);

        JPanel panel31 = new JPanel();
        panel31.setBackground(Color.black);
        panel31.setBounds(270,420,80,80);

        JPanel panel32 = new JPanel();
        panel32.setBackground(Color.black);
        panel32.setBounds(350,420,80,80);

        JPanel panel33 = new JPanel();
        panel33.setBackground(Color.black);
        panel33.setBounds(430,420,80,80);

        JPanel panel34 = new JPanel();
        panel34.setBackground(Color.black);
        panel34.setBounds(510,420,80,80);

        JPanel panel35 = new JPanel();
        panel35.setBackground(Color.black);
        panel35.setBounds(590,420,80,80);

        //ROW6-----------------------------------------------
        JPanel panel36 = new JPanel();
        panel36.setBackground(Color.black);
        panel36.setBounds(110,500,80,80);

        JPanel panel37 = new JPanel();
        panel37.setBackground(Color.black);
        panel37.setBounds(190,500,80,80);

        JPanel panel38 = new JPanel();
        panel38.setBackground(Color.black);
        panel38.setBounds(270,500,80,80);

        JPanel panel39 = new JPanel();
        panel39.setBackground(Color.black);
        panel39.setBounds(350,500,80,80);

        JPanel panel40 = new JPanel();
        panel40.setBackground(Color.black);
        panel40.setBounds(430,500,80,80);

        JPanel panel41= new JPanel();
        panel41.setBackground(Color.black);
        panel41.setBounds(510,500,80,80);

        JPanel panel42 = new JPanel();
        panel42.setBackground(Color.black);
        panel42.setBounds(590,500,80,80);
        //--------------------------------------------------


        //2D array, where each panel corresponds to a spot on the Connect 4 board
        panelArr = new JPanel[][]{
                {panel1, panel2, panel3, panel4, panel5, panel6, panel7},
                {panel8, panel9, panel10, panel11, panel12, panel13, panel14},
                {panel15, panel16, panel17, panel18, panel19, panel20, panel21},
                {panel22, panel23, panel24, panel25, panel26, panel27, panel28},
                {panel29, panel30, panel31, panel32, panel33, panel34, panel35},
                {panel36, panel37, panel38, panel39, panel40, panel41, panel42}
        };


        //setting up JFrame
        this.setTitle("Connect 4");
        this.setVisible(true);
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        //adding all panels to the JFrame
        for(int i = 0; i < panelArr.length; i++){
            for (int j = 0; j < panelArr[i].length; j++){
                this.add(panelArr[i][j]);
                panelArr[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
            }
        }

        //CREATING BUTTONS----------------------------------
        button1 = new JButton();
        button1.setBounds(110,580,80,80);
        button1.addActionListener(this);
        button1.setText("1");

        button2 = new JButton();
        button2.setBounds(190,580,80,80);
        button2.addActionListener(this);
        button2.setText("2");

        button3 = new JButton();
        button3.setBounds(270,580,80,80);
        button3.addActionListener(this);
        button3.setText("3");

        button4 = new JButton();
        button4.setBounds(350,580,80,80);
        button4.addActionListener(this);
        button4.setText("4");

        button5 = new JButton();
        button5.setBounds(430,580,80,80);
        button5.addActionListener(this);
        button5.setText("5");

        button6 = new JButton();
        button6.setBounds(510,580,80,80);
        button6.addActionListener(this);
        button6.setText("6");

        button7 = new JButton();
        button7.setBounds(590,580,80,80);
        button7.addActionListener(this);
        button7.setText("7");

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        //---------------------------------------------------


        //Other dialogue boxes--------------------------------
        JPanel messageBox = new JPanel();
        messageBox.setBounds(110,25,560,80);
        messageBox.setBorder(BorderFactory.createLineBorder(Color.black));
        messageBox.setLayout(new BorderLayout());

        message = new JLabel();
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setFont(new Font("Arial",Font.BOLD,20));

        messageBox.add(message);
        this.add(messageBox);

        JPanel player = new JPanel();
        player.setBounds(110,670,560,50);
        JLabel label = new JLabel("You are Player: " + playerNum);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial",Font.BOLD,20));
        player.add(label);
        this.add(player);
        //------------------------------------------------------

    }


    /**
     * This method can be accessed from the client class to update the message box on the GUI
     * to match what message the server has sent.
     * @param text - the message to be placed on the GUI
     */
    public void displayMessage(String text){
        message.setText(text);
    }


    /**
     * This method uses the action event interface to make the JButtons work.
     * It sends the corresponding number through sockOut to the server depending on which button is pressed.
     * This only works if 'myTurn' is TRUE, meaning it is the GUI player's turn to make a move.
     * @param e - the event to be processed
     */
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button1 && myTurn){
            sockOut.println("1");
            myTurn = false;
        }
        else if (e.getSource() == button2 && myTurn){
            sockOut.println("2");
            myTurn = false;
        }
        else if (e.getSource() == button3 && myTurn){
            sockOut.println("3");
            myTurn = false;
        }
        else if (e.getSource() == button4 && myTurn){
            sockOut.println("4");
            myTurn = false;
        }
        else if (e.getSource() == button5 && myTurn ){
            sockOut.println("5");
            myTurn = false;
        }
        else if (e.getSource() == button6 && myTurn){
            sockOut.println("6");
            myTurn = false;
        }
        else if (e.getSource() == button7 && myTurn){
            sockOut.println("7");
            myTurn = false;
        }
    }

    /**
     * This method takes the board the server sends and updates the GUI accordingly for each turn.
     * This is done by converting the string into a char array, and updating panelArr's JPanels based on if there is an 'X' or 'O' or not.
     * @param serverBoard - the board, in terminal friendly text
     */
    public void updateBoard(String serverBoard){

        char[] serverBoardArr = serverBoard.toCharArray();


        int count = 0;
        for(int i = 0; i < panelArr.length; i++){

            for (int j = 0; j < panelArr[i].length; j++){

                if (serverBoardArr[count] == 'X'){ //if X found, change that JPanel to red.
                    panelArr[i][j].setBackground(Color.red);
                    panelArr[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                }
                else if (serverBoardArr[count] == 'O'){ //if O found, change that JPanel to yellow.
                    panelArr[i][j].setBackground(Color.yellow);
                    panelArr[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                }
                count ++;
            }


        }
    }

}
