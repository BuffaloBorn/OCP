package generics.exercises;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Vitaly on 12.09.2015.
 */
public class Examples2{
    public static <T> T writeAll(Collection<T> coll, Sink<? super T> snk) {
        T last = null;

        for (T t : coll) {
            last = t;
            snk.flush(last);
        }

        return last;
    }

    public static void main(String[] args) {
        Sink<Object> s = new Sink<>();
        Collection<String> cs = new ArrayList<>();
        String str = writeAll(cs, s);
    }
}

class Sink<T> {
    public void flush(T t) {

    }
}
