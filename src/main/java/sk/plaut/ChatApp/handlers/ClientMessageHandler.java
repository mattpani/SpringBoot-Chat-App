package sk.plaut.ChatApp.handlers;

import sk.plaut.ChatApp.ciphers.Ciphers;
import sk.plaut.ChatApp.data.Messages;
import sk.plaut.ChatApp.data.Users;
import sk.plaut.ChatApp.server.SocketServer;
import sk.plaut.ChatApp.services.MessageService;
import sk.plaut.ChatApp.services.UserService;
import sk.plaut.ChatApp.utility.Utility;

import java.io.PrintWriter;


public class ClientMessageHandler {

	private final  UserService userService;
    private final MessageService messageService;

    public ClientMessageHandler(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    public void deserialization(String messageFromServer,PrintWriter output) {
        String[] newString = messageFromServer.split("#");
        String action = newString[0];
        String clientMessage = newString[1];
        String selectedMethod = newString[2];
        String user = newString[3];

        handleDeserializedMessage(action, clientMessage, selectedMethod, user,output);
    }

    private void handleDeserializedMessage(String action, String clientMessage, String selectedMethod, String user, PrintWriter output) {
        Ciphers kindCipher = Utility.getCipherMap().get(selectedMethod);

        switch (action) {
            case "Cipher":
                output.println("Cipher;" + kindCipher.cipher(clientMessage));
                break;

            case "Decipher":
                output.println("Decipher;" + kindCipher.decipher(clientMessage));
                break;

            case "Send Message":
                for (ClientHandler handler : SocketServer.listOfClients) {
                    String message = "Send Message" + ";" + user + ":" + clientMessage;
                    handler.outputToClient.println(message);
                }
                messageService.addMessage(new Messages(userService.findByName(user).getId(), clientMessage));
                break;

            case "getUser":
                Users users = userService.findByName(clientMessage);

                if (users != null) {
                    output.println("getUser;" + "true");
                    return;
                }
                output.println("getUser;" + "false");
        }
    }

}
