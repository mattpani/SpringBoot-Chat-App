package sk.plaut.ChatApp.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.plaut.ChatApp.handlers.ClientHandler;
import sk.plaut.ChatApp.services.MessageService;
import sk.plaut.ChatApp.services.UserService;
import sk.plaut.ChatApp.utility.Utility;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

@Component
public class SocketServer extends Thread {

    public static Vector<ClientHandler> listOfClients = new Vector<>();

    private final int PORT = 7676;
    private final ServerSocket serverSocket = new ServerSocket(PORT);
    private final Utility utility = new Utility();

    private final UserService userService;
    private final MessageService messageService;

    private Socket clientSocket;
    private int numOfClients = 1;


    @Autowired
    public SocketServer(UserService userService, MessageService messageService) throws IOException {
        this.userService = userService;
        this.messageService = messageService;
        start();
    }

    public void run() {
        System.out.println("Init server socket ");
        utility.initHashMap();

        while (!serverSocket.isClosed()) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(numOfClients);
            ClientHandler handler = new ClientHandler(clientSocket, this.userService, this.messageService);
            listOfClients.add(handler);
            handler.start();
            numOfClients++;
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


