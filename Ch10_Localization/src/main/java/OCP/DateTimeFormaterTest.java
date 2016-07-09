package OCP;

import print.PrintUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Created by Vitaly on 09.07.2016.
 */
public class DateTimeFormaterTest {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = dateTime.toLocalDate();
        LocalTime time = dateTime.toLocalTime();

        PrintUtils.printDelimiterString();
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        PrintUtils.printDelimiterString();
        DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(dateTime.format(shortFormatter));
        System.out.println(date.format(shortFormatter));
//        System.out.println(time.format(shortFormatter)); //java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfMonth

        PrintUtils.printDelimiterString();
        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter myF = DateTimeFormatter.ofPattern("MMMM/dd/yyyy hh;mm", Locale.US);
        System.out.println(shortF.format(dateTime));
        System.out.println(mediumF.format(dateTime));
        System.out.println(myF.format(dateTime));
//        System.out.println(Duration.ofDays(4));
//        f.format(LocalDate.now());
    }
}
