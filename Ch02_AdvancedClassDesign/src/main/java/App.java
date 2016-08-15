import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Vitaly on 10.08.2016.
 */
public class App {
    public static enum T implements Serializable{
        A, B, C;

        void doS() {
//            A = B;
        }
    }

    class C {
        //        static {int i = 0;}
//        static {int i = 0;}
        void foo() {
//            this.foo();
            App.this.doSomething();
//            foo();
        }

        void bar() {

        }

        void doSomething() {
            System.out.println(2);
        }

    }

    public static void main(String[] args) {
        new App().new C().foo();
        SortedSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> head = set.headSet(3);
        System.out.println(head);
        System.out.println(set.tailSet(3));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.compute(1, (integer, integer2) -> ++integer2);
        System.out.println(map);
        IntStream.iterate(1, i->++i).limit(5).forEach(System.out::print);
        List<? super RuntimeException> l = new ArrayList<Throwable>();
//        Stream<Integer> s = DoubleStream.of(1).mapToInt(value -> (int) value);
//        Collection<String> c = doIt(null);
//        int i = 2;
//        foo(i);
//        System.out.println(i);
    }

    static List<? super String> doIt(List<String> strings) {
        return strings;
    }

    //    static void foo(int i) {
//        ++i;
//    }
    void doSomething() {
        System.out.println(1);
    }
}
