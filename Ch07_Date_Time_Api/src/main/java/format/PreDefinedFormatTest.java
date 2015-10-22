package format;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;
import java.util.Date;
import java.util.Locale;

import static java.time.format.TextStyle.*;
import static java.time.temporal.ChronoField.*;

/**
 * Created by vitaly on 21.10.15.
 */
public class PreDefinedFormatTest {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        final String pattern = "dd.MM.YY[ HH:mm:ss]'(z)'";
        DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern(pattern, Locale.US);

        System.out.println("BASIC_ISO_DATE: " + zdt.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(defaultFormatter.format(zdt));
        System.out.println(usFormatter.format(zdt));
        System.out.println(usFormatter.format(LocalDate.now()));

        DateTimeFormatter germanFormatter = defaultFormatter.withLocale(Locale.GERMAN);

        DateTimeFormatter newYearFormatter = new DateTimeFormatterBuilder()
                .appendLiteral("New Year in ")
                .appendValue(YEAR)
                .appendLiteral(" is in ")
                .appendText(DAY_OF_WEEK, FULL_STANDALONE)
                .toFormatter();

        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()).format(newYearFormatter));
        String parsePattern = "[dd.MM.yyyy][ ][HH:mm:ss]";
        final DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern(parsePattern);
        TemporalAccessor value = parseFormatter.parse("13.08.1986 19:43:55");
        System.out.println("====================================================================");
        System.out.println(LocalDate.from(value));
        System.out.println(value.isSupported(ChronoField.HOUR_OF_DAY));
        System.out.println(parseFormatter.parse("13.08.1986", TemporalQueries.localDate()));
        TemporalAccessor ta = parseFormatter.parseBest("13.08.1986 19:43:55", LocalDate::from, LocalTime::from, LocalDateTime::from);
        System.out.println(ta.getClass());
        Date date = Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(3)));
        System.out.println(date);
        Instant instant = new Date().toInstant();
        System.out.println();
//        if (value.isSupported(ChronoField.HOUR_OF_DAY)) {
//            System.out.println(LocalDate.from(value));
//        }else if (value.isSupported(ChronoField.YEAR)) {
//            System.out.println(LocalDateTime.from(value));
//        }

    }
}
