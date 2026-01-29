/**
 * BY: Sanjay Suthakaran
 * Date: March 29, 2024
 *
 * Class Desc: This is the server class responsible for creating the connection and splitting player pairs off into connection threads.
 *
 */

package ServerSide;

import java.io.*;
import java.net.*;
public class ThreadedServer {
    public static void main(String[] args) {
        int portNumber = 1024;
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
        ) {
            while (true) {
                Socket client1=serverSocket.accept();
                System.out.println("connection 1 received.");
                Socket client2=serverSocket.accept();
                System.out.println("connection 2 received.");
                System.out.println("pairing up!");
                new ConnectionThread(client1,client2).start();
                System.out.println("game has begun!\n");

            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
