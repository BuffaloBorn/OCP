package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 09.09.15.
 */
public class BoundedTypeParameters {
    public static void main(String[] args) {
        Box<String> box = new Box<>("Hello");
        List<X> list = new ArrayList<>();
        list.add(null);
        Object o = list.get(0);
//        System.out.println(list instanceof List<? super X>); can't cast to generic type
//        box.inspect("hello"); // error: this is still String!

    }
}


class X {}

interface Y { }

interface Z { }