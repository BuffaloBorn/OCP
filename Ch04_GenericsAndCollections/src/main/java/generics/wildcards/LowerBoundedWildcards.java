package generics.wildcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by vitaly on 10.09.15.
 */
public class LowerBoundedWildcards {
    public static void main(String[] args) {

        final Object dummy = new Object();
        List<Object> objectList = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            objectList.add(dummy);
        }

        List<Integer> integerList = Collections.nCopies(10, new Integer(10));
        Collections.copy(objectList, integerList);
//        Collections.copy(integerList, objectList); //Fail
//        Collections.fill(integerList, 100);
        System.out.println(objectList);
        System.out.println(integerList);
    }
}
