package streams.ch02;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Created by vitaly on 22.09.15.
 */
public class Exercises {
    public static void main(String[] args) {
//        1.
        Function<Number, Number> x2 = x -> Math.pow(x.doubleValue(), 2);
        Function<Number, Number> x3 = x -> Math.pow(x.doubleValue(), 3);
        Function<Number, Number> sqrt2 = x -> Math.sqrt(x.doubleValue());

//        2.
        ThreadLocal<String> local = ThreadLocal.withInitial(() -> "String"); //этот вариант применяется для отложеной инициализации переменной
        ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy"));

//        3.
        Runnable runnable = () -> System.out.println("Hello world!");
        JButton button = new JButton();
        button.addActionListener(action -> System.out.println("Button pressed."));
        check((IntPredicate) x -> x > 5);
        testFunction((integer, integer2) -> integer + integer);

        @SuppressWarnings("unchecked")
        List list = new ArrayList<>();
        list.add("sdfas");

//        Object s = "sadfa";
//        @SuppressWarnings("unchecked")
//        String s1 = (String) s;


    }

    public interface IntPred {//extends IntPredicate {
        boolean test(int integer);
    }

    public static void check(IntPredicate predicate) { System.out.println("IntPredicate"); }

    public static void check(IntPred predicate) { System.out.println("IntPred"); }

    public static void testFunction(BinaryOperator<Integer> operator) { System.out.println("BinaryOperator<Integer>"); }

    public static void testFunction(BiFunction<Integer, Integer, Integer> operator) { System.out.println("BiFunction<Integer, Integer, Integer>"); }
}
