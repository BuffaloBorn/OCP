package local;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by Vitaly on 07.07.2016.
 */
public class ChronoUnitTest {
    public static void main(String[] args) {
//        Determine Duration between some dates
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.of(2016, 7, 10);
        long x = ChronoUnit.DAYS.between(start, end);
        System.out.println(x);
    }
}
