package sk.plaut.ChatApp.handlers;

import sk.plaut.ChatApp.services.MessageService;
import sk.plaut.ChatApp.services.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader inputFromClient;
    private UserService userService;
    private MessageService messageService;
    PrintWriter outputToClient;

    public ClientHandler(Socket clientSocket, UserService userService, MessageService messageService) {
        this.messageService = messageService;
        this.userService = userService;
        this.socket = clientSocket;
    }

    public void run() {
        ClientMessageHandler clientMessageHandler = new ClientMessageHandler(userService,messageService);
        
    	System.out.println("In client hanlder");
        try {
            while (!socket.isClosed()) {
                outputToClient = new PrintWriter(socket.getOutputStream(), true);
                inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (socket.isConnected()) {
                    String message = inputFromClient.readLine();
                    if (message == "") {
                        continue;
                    }
                    clientMessageHandler.deserialization(message,outputToClient);
                }
                inputFromClient.close();
                outputToClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {

            }
        }
    }

}
