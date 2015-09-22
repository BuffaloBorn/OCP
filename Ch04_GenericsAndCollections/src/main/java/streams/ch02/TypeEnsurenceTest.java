package streams.ch02;

import java.util.function.Predicate;

/**
 * Created by vitaly on 22.09.15.
 */
public class TypeEnsurenceTest {
    public static void main(String[] args) {
        Predicate<String> predicate = String::isEmpty;
        Predicate predicate1 = (Object s) -> s.toString().isEmpty();

    }
}
