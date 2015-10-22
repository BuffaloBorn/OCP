package zone;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.*;

/**
 * Created by vitaly on 21.10.15.
 */
public class TimeBetween {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.now().minusDays(8);
        LocalDate endDate = LocalDate.now();

        long minutes = MINUTES.between(startDate, endDate);
        long days = startDate.until(endDate, DAYS);
        Period p = startDate.until(endDate);

    }
}
