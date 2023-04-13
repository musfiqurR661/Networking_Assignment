import util.NetworkUtil;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class ReadThreadServer implements Runnable {
    private String clientName;
    //private NetworkUtil networkUtil;
    private HashMap<String, NetworkUtil> clientMap;

    public ReadThreadServer(Socket clientSocket) {

        this.clientSocket = clientSocket;
    }

    //    public ReadThreadServer(String clientName, NetworkUtil networkUtil, HashMap<String, NetworkUtil> clientMap) {
//        this.clientName = clientName;
//        this.networkUtil = networkUtil;
//        this.clientMap = clientMap;
//    }
private Socket clientSocket;

    @Override
    public void run() {
        try {
            NetworkUtil networkUtil = new NetworkUtil(clientSocket);
            while (true) {
                Message msg = (Message) networkUtil.read();
                if (msg != null) {
                    String toClientName = msg.getTo();
                    String message = msg.getText();
                    String from = msg.getFrom();

                    if (toClientName != null) {
                        NetworkUtil toClient = clientMap.get(toClientName);

                        if (toClient != null) {

                            // sending to appropriate client

                            toClient.write(msg);
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {

            // if class is not found, that means client left the chat (application terminated) so remove the client from the hashmap
            clientMap.remove(clientName);
            System.out.println(clientName+ "Left the chat");
        }
    }
}


