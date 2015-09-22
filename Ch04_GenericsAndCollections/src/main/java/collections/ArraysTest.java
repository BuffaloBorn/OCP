package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vitaly on 13.09.2015.
 */
public class ArraysTest {
    public static void main(String[] args) {
//        Arrays.max
    }
}

class LastError<T> {
    private T lastError;

    void setError(T t) {
        lastError = t;
        System.out.println("LastError: setError");
    }
}

class StrLastError<S extends CharSequence> extends LastError<String> {
    public StrLastError(S s) {
    }

    void setError(S s) {
        System.out.println("StrLastError: setError");
    }
}

class Test {
    public static void main(String[] args) {
        StrLastError<String> err = new StrLastError<String>("Error");
        List<? super String> list = new ArrayList<>();
        list.add("sdf");
//        err.setError();
//        err.setError("Last error");
    }
}