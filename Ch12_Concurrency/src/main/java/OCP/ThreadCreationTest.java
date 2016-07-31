package OCP;

/**
 * Created by Vitaly on 30.07.2016.
 */
public class ThreadCreationTest {
    public static void main(String[] args) {
        System.out.println("Start...");
        Thread th1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Printing zoo inventory");
            }
        };

        Runnable r1 = () ->{ for (int i = 0; i < 10; i++) {
            System.out.println("Printing record: "+i);
        }};

        th1.start();
        new Thread(r1).start();
        System.out.println("End.");
    }
}
