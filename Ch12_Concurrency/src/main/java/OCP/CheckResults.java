package OCP;

import java.util.concurrent.TimeUnit;

/**
 * Created by Vitaly on 30.07.2016.
 */
public class CheckResults {
    public static final int BORDER = 5000000;
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start-->");
        new Thread(() -> {
            Double x = 100.0;
            synchronized (CheckResults.class) {
                for (int i = 0; i < BORDER; i++) {
                    counter++;
                    x = x / x;
                }
                CheckResults.class.notifyAll();
            }

        }).start();

//        synchronized (CheckResults.class) {
            while (counter < BORDER) {
                System.out.println("Not reached!");
                TimeUnit.NANOSECONDS.sleep(50000000);
//                CheckResults.class.wait();
            }
//        }

        System.out.println("<--End");
    }
}


