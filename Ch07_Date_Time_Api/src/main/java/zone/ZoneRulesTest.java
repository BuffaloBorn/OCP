package zone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;
import java.util.List;

/**
 * Created by vitaly on 16.10.15.
 */
public class ZoneRulesTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("ldt = " + now);

        ZoneId fixedZoneId = ZoneId.of("+06:00");
        ZoneId uaKiev = ZoneId.of("Europe/Kiev");
        ZoneId usChicago = ZoneId.of("America/Chicago");

//        Print some zone rules for ZoneIds
        printDetails(fixedZoneId, now);
        printDetails(uaKiev, now);
        printDetails(usChicago, now);
    }

    private static void printDetails(ZoneId zoneId, LocalDateTime dateTime) {
        ZoneRules rules = zoneId.getRules();
        System.out.println("rules.isFixedOffset() = " + rules.isFixedOffset());

        ZoneOffset offset = rules.getOffset(dateTime);
        System.out.println("offset = " + offset);

        List<ZoneOffsetTransition> transitions = rules.getTransitions();
        System.out.println("transitions = " + transitions);
    }
}
