import java.util.ArrayList;

public class NetworkInformation {
    ArrayList<String> inbox = new ArrayList<>();

    public ArrayList<String> getInbox() {
        return inbox;
    }

    public void setMessages(String message) {
        inbox.add(message);
    }


}
