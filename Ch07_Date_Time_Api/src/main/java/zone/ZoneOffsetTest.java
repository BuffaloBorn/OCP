package zone;

import java.time.ZoneOffset;

/**
 * Created by vitaly on 15.10.15.
 */
public class ZoneOffsetTest {
    public static void main(String[] args) {
        //Create zone offset using hour, minute and second
        ZoneOffset zos01 = ZoneOffset.ofHours(-6);
        ZoneOffset zos02 = ZoneOffset.ofHoursMinutes(5, 30);
        ZoneOffset zos03 = ZoneOffset.ofTotalSeconds(8405);

        System.out.println("zos01 = " + zos01);
        System.out.println("zos02 = " + zos02);
        System.out.println("zos03 = " + zos03);

        //Creating zone offset ID as String
        ZoneOffset zos04 = ZoneOffset.of("+05:00");
        ZoneOffset zos05 = ZoneOffset.of("Z");

        System.out.println("zos04 = " + zos04);
        System.out.println("zos05 = " + zos05);
        System.out.println("ZoneOffset.of(\"Z\") == ZoneOffset.UTC : " + (zos05 == ZoneOffset.UTC));
        System.out.println("ZoneOffset.MIN = " + ZoneOffset.MIN);
        System.out.println("ZoneOffset.MAX = " + ZoneOffset.MAX);

    }
}
