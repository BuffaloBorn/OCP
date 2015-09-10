package generics.wildcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vitaly on 10.09.15.
 */
public class UpperBoundedWildcards {
    public static <T  extends Number> double sum(List<T> list) {
        return list.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void main(String[] args) {
        List<Integer> list = Collections.nCopies(10, 5);
        System.out.println(sum(list));
        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(11);
        List<? extends Number> someList = integers;
//        someList.add(new Integer(10)); //Fail Нельзя модифицировать состояния дженерика с wildcard
        Number value = someList.get(0); //Получать значения можно
        System.out.println(value);
    }
}
