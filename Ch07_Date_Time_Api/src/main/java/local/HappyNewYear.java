package local;

import java.time.MonthDay;
import java.time.Year;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by vitaly on 21.10.15.
 */
public class HappyNewYear {
    public static void main(String[] args) {
        MonthDay newYear = MonthDay.of(12, 31);

        for (int i = 1986; i < 2020; i++) {
            System.out.printf("%d: %s%n", i, Year.of(i).atMonthDay(newYear).getDayOfWeek());
        }

        TemporalAdjuster x = TemporalAdjusters.lastDayOfMonth();
        System.out.println(x);
    }
}
