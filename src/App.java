import java.net.InetAddress;

public class App {
    public static void main(String[] args) throws Exception {
        // IP Address
        InetAddress addr= InetAddress.getLocalHost();
        // Host name
        System.out.println("Host name is: "+ addr.getHostName());
        // Host Address
        System.out.println("Ip address is: "+ addr.getHostAddress());
    }
}
