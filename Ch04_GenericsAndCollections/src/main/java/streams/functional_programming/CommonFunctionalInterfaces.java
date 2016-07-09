package streams.functional_programming;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Supplier;

/**
 * Created by Vitaly on 19.06.2016.
 */
public class CommonFunctionalInterfaces {
    public static void main(String[] args) {
        //SUPPLIER
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();
        Supplier<ArrayList<String>> s3 = ArrayList::new;

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        ArrayList<String> strings = s3.get();

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(s3);

//        F f = new F() {
//            @Override
//            public boolean doIt() {
//                return false;
//            }
//        };
//        F f = s3.get()::isEmpty;
//        System.out.println(f);

    }
}

interface F {
    boolean doIt();
}