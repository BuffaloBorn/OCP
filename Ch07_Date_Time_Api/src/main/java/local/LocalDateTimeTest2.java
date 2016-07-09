package local;

import print.PrintUtils;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import static print.PrintUtils.*;

/**
 * Created by vitaly on 14.10.15.
 */
public class LocalDateTimeTest2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015, Month.JULY, 6);
        LocalTime time = LocalTime.of(15, 25);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        printSectionName("LocalDateTime");
        System.out.println(dateTime);
        System.out.println(dateTime.minusDays(1));
        System.out.println(dateTime.minusHours(5));
        System.out.println(dateTime.minusSeconds(7));
        printDelimiterString();
    }
}
