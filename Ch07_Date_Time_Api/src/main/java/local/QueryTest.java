package local;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.*;

/**
 * Created by vitaly on 21.10.15.
 */
public class QueryTest {
    public static void main(String[] args) {
        TemporalQuery<TemporalUnit> precisionQuery = TemporalQueries.precision();
        TemporalQuery<LocalDate> localDateQuery = TemporalQueries.localDate();
        TemporalQuery<ZoneId> zoneIdQuery = TemporalQueries.zoneId();
        LocalDate ld01 = LocalDate.now();
        TemporalUnit smallestUnit = ld01.query(precisionQuery);
        System.out.println(smallestUnit);
//        ld01.adjustInto(smallestUnit);
//        Query = TemporalQueries.();
//        Query = TemporalQueries.();
    }
}
