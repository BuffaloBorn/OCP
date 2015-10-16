package local;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by vitaly on 16.10.15.
 */
public class MonthTest {
    public static void main(String[] args) {
        LocalDate ld01 = LocalDate.now();

        Month m01 = Month.from(ld01);
        Month m02 = Month.of(2);
        Month m03 = m02.plus(5);
        Month m04 = ld01.getMonth();
        int m05 = m03.getValue();

        System.out.printf("%s, %s, %s, %s, %d\n", m01, m02, m03, m04, m05);
    }
}
