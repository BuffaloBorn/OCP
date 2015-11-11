package ekel;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by vitaly on 11.11.15.
 */
public class ClosingIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket socket = new ServerSocket(8080);
        InputStream sin = new Socket("localhost", 8080).getInputStream();
        InputStream in = System.in;
        exec.execute(new IOBlocked(sin));
        exec.execute(new IOBlocked());
        TimeUnit.MILLISECONDS.sleep(500);
        exec.shutdownNow();
        System.out.println("Closing socket");
        sin.close();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Closing System.in");
        in.close();
    }
}
