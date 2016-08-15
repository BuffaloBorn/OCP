package OCP;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

//import static OCP.App.Color.R;

/**
 * Hello world!
 *
 */
public class App
{
    //     enum E{EEE(R);
//
//
//        E(Color r) {
////            E e = E.EEE;
//        }
//    }
//
//     enum Color {
//        R
//    }
//    public E e;
    public static int compareTo(int x, int y) {
        return x - y;
    }
    public static void main(String[] args) {
        Consumer<Path> c = Files::exists;
        System.out.println("Hello World!");
        System.out.println(Stream.of(",,,")
                .flatMap(s -> Stream.of(s.split(",")))
                .filter(s -> s.trim().length() > 0)
                .allMatch(s -> args.length > 3));
        System.out.println(Stream.empty().noneMatch(o -> false));
        System.out.println(Stream.empty().anyMatch(o -> false));
//        String s = (String) new Object();
        System.out.println(compareTo( Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(compareTo( 1,2));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        CyclicBarrier cb = new CyclicBarrier(4, () -> System.out.println("Done"));
        ExecutorService exec = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 12; i++) {
            exec.submit((Callable<Integer>) cb::await);
        }
        exec.shutdown();
//        Queue<Integer> q =
//        System.out.println(Stream.empty().anyMatch(o -> true));
    }
}

abstract interface A {

}