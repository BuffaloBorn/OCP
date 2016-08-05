package OCP;

import java.io.IOException;
import java.net.*;

/**
 * Created by Vitaly on 03.08.2016.
 */
public class Pinger {
    public static void main(String[] args) throws UnknownHostException, IOException {
        SocketAddress sockaddr = new InetSocketAddress("remote.alfa-holding.net", 3397);
//        SocketAddress sockaddr = new InetSocketAddress("localhost", 80);
// Create your socket
        boolean online = true;
        try (Socket socket = new Socket();
        ) {

            // Connect with 10 s timeout
            socket.connect(sockaddr, 10000);
        } catch (SocketTimeoutException stex) {
            // treating timeout errors separately from other io exceptions
            // may make sense
            online = false;
        } catch (IOException iOException) {
            online = false;
        }

// Now, in your initial version all kinds of exceptions were swallowed by
// that "catch (Exception e)".  You also need to handle the IOException
// exec() could throw:
        if (!online) {
//            System.out.println("OFFLINE: Restarting Server..");
//            try {
//                Runtime.getRuntime().exec("cmd /c start start.bat");
//            } catch (IOException ex) {
//                System.out.println("Restarting Server FAILED due to an exception " + ex.getMessage());
//            }
            System.out.println("server offline");
        } else {
            System.out.println("server online");
        }
    }
}
