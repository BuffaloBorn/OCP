package generics.wildcards;

import java.io.FileNotFoundException;
import java.io.IOException;
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

        List<Integer> integerList = Collections.nCopies(10, 10);
        Collections.copy(objectList, integerList);
//        Collections.copy(integerList, objectList); //Fail
//        Collections.fill(integerList, 100);
        System.out.println(objectList);
        System.out.println(integerList);

        List<? super IOException> list = new ArrayList<>();
//        list.add(new Exception()); Not compile
        list.add(new IOException());
        list.add(new FileNotFoundException());

        List<? super String> l = doit(new ArrayList<String>());
        List<? super String> list1 = new ArrayList<String>();
//        List<String> list2 = list1;
    }

    public static <E extends CharSequence> List<? super E> doit(List<E> in) {
        return null;
    }
}
