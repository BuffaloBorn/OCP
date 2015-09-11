package generics.wildcards;

import java.util.List;

/**
 * Created by vitaly on 10.09.15.
 */
public class WildcardCaptureAndHelperMethods {
    public static void main(String[] args) {
        Class<Integer> aClass = WildcardFixed.bar();
    }
}

class WildcardFixed {

//    public static Class<?> bar() { return null; } //BAD IDEA
    public static Class bar() { return null; } //SO SO :/, But much better than above

    void foo(List<?> i) {
        fooHelper(i);
    }

//    void fooBad(List<?> l) {l.set(0, l.get(0));} //FAIL incompatible types: java.lang.Object cannot be converted to capture#1 of ?

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }

}