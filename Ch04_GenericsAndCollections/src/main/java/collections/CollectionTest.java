package collections;

import java.util.*;

/**
 * Created by Vitaly on 15.06.2016.
 */
public class CollectionTest {
    public static void main(String[] args) {
        //retain all
        Collection<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(1, 2, 3, 4, 5));
        integers.retainAll(Arrays.asList(1, 2));
        System.out.println(integers);
        Object[] array = integers.toArray();

        //listIterator(index)
        List<Integer> integerList = (List<Integer>) integers;
        ListIterator<Integer> listIterator = integerList.listIterator(1);
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        //subList
        integers.addAll(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> sublist = integerList.subList(1, 3);
        System.out.println(sublist);
        System.out.println(integerList);
        sublist.clear();
        System.out.println(integerList);

        System.out.println();
    }
}
