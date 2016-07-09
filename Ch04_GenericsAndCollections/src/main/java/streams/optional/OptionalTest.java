package streams.optional;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Vitaly on 05.07.2016.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Integer> l = Optional.of(5);
        l.ifPresent(System.out::println);
        l = Optional.ofNullable(null);
//        l = Optional.of(null); //throws exception

        Optional<String> s = Optional.of(1).map(Objects::toString).filter(s1 -> s1.length() > 3);
        System.out.println(s);
        try {
            foo(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void foo(F f) throws IOException {
//        try {
            f.doSomething(1);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}

@FunctionalInterface
interface F {
    void doSomething(int i) throws IOException;
}