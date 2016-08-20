package OCP;

import print.PrintUtils;

import java.io.Console;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Hello world!
 */
interface A {
    default void foo() {

    }

    static void bar() {

    }
}

interface B extends A {
    default void bar() {

    }

    default void foo() {

    }
}

class TestClass1 {
    static {
        System.out.println("in static");
    }

}

//abstract class X<T> {
abstract interface X<T> {
    public abstract void foo(T e);
}

public class App implements Serializable {
    static {
        System.out.println("non static");
        X<String> x = System.out::println;
    }
    public App(int i) {
        this.i = i;
    }

    int i = 1;

    class A {
        int i = 2;

        //        static final String name = "";
//
//        void foo() {
//
//        }
        void foo() {
            System.out.println(A.this.i);
            System.out.println(App.this.i);
        }
    }

    public void foo() {
        App t = App.this;
    }

    public static void main(String[] args) throws URISyntaxException {
        String s = Arrays.asList("a", "b", "c").parallelStream().reduce("_", String::concat);
        System.out.println(s);
        Duration d = Duration.between(LocalDateTime.now(), LocalDateTime.now().minusSeconds(15).minusMinutes(3).minusHours(1));
        System.out.println(d);
        Predicate p = o -> false;
        System.out.println(Arrays.toString(new Random().ints(10).limit(5).boxed().toArray(value -> new Integer[5])));
        Path p1 = Paths.get(new URI("file://e:/temp/records"));
        Path p2 = Paths.get(new URI("file://c:/1"));
        Console c = System.console();
        TestClass1 t;
        t = new TestClass1();
//        while (true) { }
//        for (;;){}
//        System.out.println("");
//        for (FileSystemProvider provider :FileSystemProvider.installedProviders()) {
//            System.out.println(provider);
//        }

//        Map<String, Integer> map = new HashMap<>();
//        map.put("A", null);
//        map.put("B", 1);
//        System.out.println(map);
//        System.out.println(map.merge("A", 2, (k, v) -> k));
//        System.out.println(map.merge("B", 2, (v1, v2) -> null));
////        System.out.println(map.compute("B", (s, i) -> i++));
////        System.out.println(map.compute("C", (s, i) -> i));
//        System.out.println(map);
//        CyclicBarrier cb = new CyclicBarrier(3, () -> {System.out.println(Thread.currentThread() + "Finish!!!");});
//        ExecutorService exec = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 3; i++) {
//            exec.submit(() -> {System.out.println(Thread.currentThread()); cb.await(); return null;});
//        }
//        exec.shutdown();
//        Stream.generate(() -> "F").distinct().limit(4).count();
//        dateTime = LocalDateTime.now().to
//        System.out.println(Period.of(1, 1, 1));
//        System.out.println(Duration.of(1, ChronoUnit.DAYS).plusDays(3).plusHours(2).plusSeconds(7).plusMinutes(4));
//        System.out.println(Instant.now().plus(1, ChronoUnit.DAYS));
//        PrintUtils.printDelimiterString();
//        System.out.println(Duration.ofSeconds(3600));
//        System.out.println(Duration.of(60 * 60, ChronoUnit.SECONDS));
//        System.out.println(Stream.empty().allMatch(o -> false));
//        System.out.println(Paths.get("C:/").getFileName());
//        Map<Integer, Long> m = Stream.<String>empty().collect(groupingBy(String::length, counting()));
//        new App().new A().foo();
//        class A {
//            static final String name = "";
//        }
//        Stream.empty().reduce()/
//        System.out.println(Period.of());
    }

//    public void foo() {
//        class A {
//            static final String name = "";
//        }
//
//    }
}

//interface Home {
//    static void getAddress() {
//
//    }
//}
//interface Office {
//    default void getAddress() {
//
//    }
//}
//
//interface HomeOffice extends Home, Office {
//
//}
//
//class HMC implements HomeOffice {
//    public String getAddress() {
//
//    }
//    public static void main(String[] args) {
//        HMC hmc = new HMC();
//        hmc.getAddress();
//        Home.getAddress();
//    }
//}