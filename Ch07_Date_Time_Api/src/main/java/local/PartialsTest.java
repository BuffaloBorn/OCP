package local;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

/**
 * Created by vitaly on 21.10.15.
 */
public class PartialsTest {
    public static void main(String[] args) {
        Year year = Year.now();
        MonthDay monthDay = MonthDay.of(Month.FEBRUARY, 29);
        for (int i = 1986; i < 2015; i++) {
            System.out.println(monthDay.isValidYear(i));
        }

    }
}

