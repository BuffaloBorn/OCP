package zone;

import java.time.*;

/**
 * Created by vitaly on 21.10.15.
 */
public class PeriodTest {
    public static void main(String[] args) {
        ZoneId usCentral = ZoneId.of("America/Chicago");
        LocalDateTime ldt = LocalDateTime.of(2012, Month.MARCH, 10, 7, 30);
        ZonedDateTime zdtC = ZonedDateTime.of(ldt, usCentral);
        Period p1 = Period.ofDays(1);
        Duration d1 = Duration.ofDays(1);
        System.out.println("Start: " + zdtC);
        System.out.println("+Period: " + zdtC.plus(p1));
        System.out.println("+Duration: " + zdtC.plus(d1));

    }
}
