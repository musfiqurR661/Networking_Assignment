import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private ServerSocket serverSocket;
    private HashMap<String, NetworkUtil> clientMap;
    NetworkInformation networkInformation = new NetworkInformation();

    Server() {
        clientMap = new HashMap<>();
        try {
            serverSocket = new ServerSocket(33338);
            System.out.println("Server has started...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Server has accepted a connection...");
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException, InterruptedException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        String clientName = (String) networkUtil.read();
        clientMap.put(clientName, networkUtil);  // set userName
        System.out.println(clientName+" Joined");

        // Start the read and write threads for the client
       Thread t1 = new Thread(new ReadThreadServer(clientSocket));
       //Thread t2 = new Thread(new WriteThreadServer( clientMap, clientName));

        t1.start();
       // t2.start();
//        t1.join();
//        t2.join();
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}
