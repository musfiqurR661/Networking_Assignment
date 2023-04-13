//import util.NetworkUtil;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class WriteThreadServer implements Runnable {
//    private HashMap<String, NetworkUtil> clientMap;
//    private String serverName;
//
////    public WriteThreadServer(HashMap<String, NetworkUtil> clientMap, String serverName) {
////        this.clientMap = clientMap;
////        this.serverName = serverName;
////    }
//
//    @Override
//    public void run() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String message = scanner.nextLine();
//            String[] parts = message.split(" ", 2);
//            if (parts.length == 2) {
//                String to = parts[0];
//                String text = parts[1];
//
//                NetworkUtil toClient = clientMap.get(to);
//
//                if (toClient != null) {
//                    Message msg = new Message();
//                    try {
//                        toClient.write(msg);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                } else {
//                    System.out.println("Client not found: " + to);
//                }
//            } else {
//                System.out.println("Invalid message format.");
//            }
//        }
//    }
//}
//
//
