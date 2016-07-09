package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Vitaly on 13.06.2016.
 */
class Dragon { }

class Unicorn { }

public class LegacyCode {
    public static void main(String[] args) {
//        List numbers = new ArrayList();
//        numbers.add(1);
//        int i = numbers.get(0);//Not compile Потому что идет преобразование из Object -> int

        List unicorns = Collections.nCopies(5, new Unicorn());
        printDragons(unicorns);
    }

    public static void printDragons(List<Dragon> dragons) {
        for (Dragon dragon :dragons) { //ClassCastException потому что передается raw type и идет неявное кастование
            System.out.println(dragon);
        }
    }
}
