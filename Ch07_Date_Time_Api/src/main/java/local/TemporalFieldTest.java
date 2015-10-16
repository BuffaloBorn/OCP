package local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;

/**
 * Created by vitaly on 16.10.15.
 */
public class TemporalFieldTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        System.out.println("YEAR = " + now.get(ChronoField.YEAR));
        System.out.println("MONTH_OF_YEAR = " + now.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("DAY_OF_MONTH = " + now.get(ChronoField.DAY_OF_MONTH));
        System.out.println("HOUR_OF_DAY = " + now.get(ChronoField.HOUR_OF_DAY));
        System.out.println("HOUR_OF_AMPM = " + now.get(ChronoField.HOUR_OF_AMPM));
        System.out.println("AMPM_OF_DAY = " + now.get(ChronoField.AMPM_OF_DAY));

        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);
        System.out.println("ChronoField.YEAR.isSupportedBy(today) = " + ChronoField.YEAR.isSupportedBy(today));
        System.out.println("ChronoField.HOUR_OF_DAY.isSupportedBy(today) = " + ChronoField.HOUR_OF_DAY.isSupportedBy(today));
        System.out.println("QUARTER_OF_YEAR = " + today.get(IsoFields.QUARTER_OF_YEAR));

    }
}
