package zone;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by vitaly on 16.10.15.
 */
public class DateTimeZoneConversion {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        ZoneId usCentral = ZoneId.of("America/Chicago");
        ZonedDateTime zdt_c = ZonedDateTime.of(ldt, usCentral);
        ZoneId sven = ZoneId.of("Europe/Stockholm");
        ZonedDateTime zdt_s = ZonedDateTime.now().withZoneSameInstant(sven);

        System.out.println("Local: " + ldt);
        System.out.println("Chicago: " + zdt_c);
        System.out.println("Stockholm: " + zdt_s);
        System.out.println("===========================================================================");

        Clock systemClock = Clock.system(usCentral);
        System.out.println(LocalDateTime.now(systemClock));

    }
}
