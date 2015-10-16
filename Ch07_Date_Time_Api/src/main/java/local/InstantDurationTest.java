package local;

import java.time.*;

/**
 * Created by vitaly on 15.10.15.
 */
public class InstantDurationTest {
    public static void main(String[] args) {
//        Instant
        Instant i01 = Instant.now();
        Instant i02 = Instant.ofEpochSecond(19);

        //Get seconds and nanos
        long secnonds = i01.getEpochSecond();
        int nanos = i01.getNano();

        System.out.println("Current Instant: " + i01);
        System.out.println("secnonds = " + secnonds);
        System.out.println("nanos = " + nanos);
        System.out.println();

//        Duration
        Duration d01 = Duration.ofDays(2).plusHours(4);
        Duration d02 = Duration.between(LocalDate.of(1986, 8, 13).atStartOfDay(), LocalDateTime.now());


        Instant i03 = Instant.ofEpochSecond(20);
        Instant i04 = Instant.ofEpochSecond(55);
        System.out.println("i03 = " + i03);
        System.out.println("i04 = " + i04);

        Duration d03 = Duration.ofSeconds(55);
        Duration d04 = Duration.ofSeconds(-17);
        System.out.println("d03 = " + d03);
        System.out.println("d04 = " + d04);

        //Compare Instants
        System.out.println("i03.isBefore(i04) = " + i03.isBefore(i04));
        System.out.println("i03.isAfter(i04) = " + i03.isAfter(i04));

        //Add and subtract durations to instants
        System.out.println("i03.plus(d03) = " + i03.plus(d03));
        System.out.println("i04.minus(d04) = " + i04.minus(d04));

        System.out.println("d04.plus(d03) = " + d04.plus(d03));
        System.out.println();

        System.out.println(Period.parse("P2d"));
        System.out.println(LocalDateTime.now().plus(Duration.ofHours(100).withSeconds(5866324)));
        System.out.println(Period.between(LocalDate.of(1986, 8, 13), LocalDate.now()));

    }
}
