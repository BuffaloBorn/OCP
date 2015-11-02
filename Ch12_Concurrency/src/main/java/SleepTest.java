import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 02.11.15.
 */
public class SleepTest {
    private static Random rnd = new Random();

    public static void main(String[] args) throws InterruptedException {
        List<String> strings = Arrays.asList(
                "Я"
                , "ходил"
                , "на"
                , "улицу"
                , "и"
                , "ловил"
                , "жуков."
        );


        for (String s : strings) {
            if (Thread.interrupted()) {
                return;
            }

            System.out.println(s);
            TimeUnit.MILLISECONDS.sleep(500);

//            if (randomBoolean()) {
//                Thread.currentThread().interrupt();
//            }
        }

    }

    public static boolean randomBoolean() {
        return rnd.nextBoolean();
    }
}

