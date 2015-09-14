package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Vitaly on 13.09.2015.
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 5, 8, 6, 7, 3, 5, 8, 2, 4, 8, 2, 4);
        System.out.println(list);
        Collections.replaceAll(list, 8, 0);
        System.out.println(list);
        Collections.rotate(list, -2);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
