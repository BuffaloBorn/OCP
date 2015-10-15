package local;

import java.time.*;
import java.time.temporal.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 14.10.15.
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
//        The ofXXX( ) Methods
        LocalDate ld01 = LocalDate.of(2015, 10, 15);
        LocalDate ld02 = LocalDate.of(2015, Month.OCTOBER, 15);
        LocalDate ld03 = LocalDate.ofEpochDay(2002);
        LocalDate ld04 = LocalDate.ofYearDay(2015, 256);

//        The from( ) Methods
        LocalDateTime ldt01 = LocalDateTime.of(2015, 10, 15, 14, 27);
        LocalDate ld5 = LocalDate.from(ldt01);

//        The withXXX( ) Methods
        LocalDate ld06 = LocalDate.now();
        LocalDate ld07 = ld06.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate ld09 = ld06.with(ChronoField.MONTH_OF_YEAR, 5);
        LocalDate ld08 = ld06.withDayOfMonth(25);
        LocalDate ld10 = ld06.withDayOfYear(256);
        LocalDate ld11 = ld06.withMonth(8);
        LocalDate ld12 = ld06.withYear(1986);

//        The getXXX( ) Methods
        ld01.get(ChronoField.DAY_OF_WEEK);
        ld01.getLong(ChronoField.EPOCH_DAY);
        ld01.getMonth();
        ld01.getMonthValue();
        ld01.getYear();
        ld01.getDayOfYear();

//        The toXXX( ) Methods
        ldt01.toLocalDate();
        ldt01.toLocalTime();

//        The atXXX( ) Methods
        LocalDateTime ldt02 = ld01.atStartOfDay();
        LocalDateTime ldt03 = ld01.atTime(12, 30);
        LocalDate ld13 = Year.of(1986).atMonth(8).atDay(13); // Bilder example

//        The plusXXX( ) and minusXXX( ) Methods
        LocalDate ld14 = ld01.plus(3, ChronoUnit.WEEKS);
        LocalDate ld15 = ld01.plusDays(5);
        LocalDate ld16 = ld01.plusYears(8);
        LocalDate ld17 = ld01.plusMonths(1);
        LocalDate ld18 = ld01.minus(6, ChronoUnit.YEARS);
        LocalDate ld19 = ld01.minusDays(2);

//        The multipliedBy( ), dividedBy( ), and negated( ) Methods
        Duration d01 = Duration.ofSeconds(360);
        Duration d02 = d01.multipliedBy(2);
        Duration d03 = d01.dividedBy(3);
        Duration d04 = d01.negated();
    }
}
