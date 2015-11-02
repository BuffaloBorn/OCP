import java.time.DayOfWeek;

/**
 * Created by vitaly on 02.11.15.
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {

        Runnable r = () -> {
            try {
                SleepTest.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            System.out.printf("В %s ", dayOfWeek);
            Thread thread = new Thread(r);
            thread.start();
            thread.join();
        }

    }
}
