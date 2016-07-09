package local;

import print.PrintUtils;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

import static java.time.Month.*;
import static print.PrintUtils.*;

/**
 * Created by Vitaly on 06.07.2016.
 */
public class PeriodDurationTest {
    public static void main(String[] args) throws InterruptedException {
        printSectionName("By Days");
        performAnimalEnrichment(LocalDate.now(), LocalDate.now().plusDays(5));
        printSectionName("By Period");
        performAnimalEnrichment(LocalDate.now(), LocalDate.now().plusDays(5), Period.ofDays(3));
        printSectionName("Epoch");
        System.out.println(LocalDate.of(1960, JANUARY, 3).toEpochDay());
        System.out.println(LocalDateTime.of(1970, JANUARY, 1, 0, 1).toEpochSecond(ZoneOffset.ofHoursMinutes(0, 2)));
        printSectionName("Print Period");
        System.out.println(Period.ZERO.of(1, 2, 3));
        System.out.println(Period.ofWeeks(8));
        printSectionName("Print Duration");
        Duration d = Duration.ofSeconds(4, 5);
        System.out.println(LocalDateTime.now().plus(d));
        printSectionName("Print Duration of Instant");
        Instant start = Instant.now();
        TimeUnit.NANOSECONDS.sleep(1);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
        printSectionName("Print Duration of Instant");
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("+05:00"));
        System.out.println(zdt);
        Instant instant = zdt.toInstant();
        System.out.println(instant);
//        instant.plus(1, ChronoUnit.MONTHS); //UnsupportedTemporalTypeException: Unsupported unit: Months
        System.out.println(LocalDateTime.now());
        printSectionName("Print Day light save time");
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
        dateTime = dateTime.plusHours(1);
        System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]

    }

    public static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        LocalDate now = start;
        while (now.isBefore(end)) {
            System.out.println("get new toy: " + now);
            now = now.plus(1, ChronoUnit.DAYS);
        }
    }
    public static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
        LocalDate now = start;
        while (now.isBefore(end)) {
            System.out.println("get new toy: " + now);
            now = now.plus(period);
        }
    }
}
