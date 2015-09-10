package generics.wildcards;

/**
 * Created by vitaly on 09.09.15.
 */
public class BoundedTypeParameters {
    public static void main(String[] args) {
        Box<String> box = new Box<>("Hello");
//        box.inspect("hello"); // error: this is still String!

    }
}


class X {}

interface Y { }

interface Z { }