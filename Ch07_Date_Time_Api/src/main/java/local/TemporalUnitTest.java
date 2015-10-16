package local;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Created by vitaly on 16.10.15.
 */
public class TemporalUnitTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime ldt01 = now.plus(5, ChronoUnit.WEEKS);
        LocalDateTime ldt02 = now.plusDays(5);

        LocalDateTime ldt04 = now.plusHours(5);
        LocalDateTime ldt05 = now.plus(5, ChronoUnit.HOURS);

        System.out.println("ldt04 = ldt05 : " + ldt04.equals(ldt05));

        now.plus(Period.ofDays(5));


    }
}
