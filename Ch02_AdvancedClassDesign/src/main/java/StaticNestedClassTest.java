import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Vitaly on 06.09.2015.
 */
class Circle extends Shape {
    private int x, y;
    private int radius;
    private Point center;

    public Circle(int x, int y, int radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public class Point {
        //        public static String string;
        private int x, y;

        public Point() {
            this(0, 0);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            Circle.this.x = x;
        }

        public Circle getCircle() {
            return Circle.this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("x=").append(x);
            sb.append(", y=").append(y);

            return sb.toString();
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append(center);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }

    public Point getCenter() {
        return center;
    }
}

interface A {
    String text = "a";

    default void foo() {
        System.out.println(text);
    }
}

interface B {
    String text = "b";

    //    default void foo() {
//        System.out.println(text);
//    }
    void foo();

}

class Parent implements A {

}

//class Implementator extends Parent implements A, B {
//
//}

public class StaticNestedClassTest {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 8);
        System.out.println(circle);
        Circle.Point point = circle.getCenter();
        System.out.println(point.getCircle() == circle);
//        new Implementator().foo();

        List<Integer> integers = IntStream.range(0, 10).boxed().collect(Collectors.toList());
//        Collector collector = new ShuffleCollector<>() {
//        };
    List<Integer> shuffleInts = integers.stream().collect(new ShuffleCollector<>());
        System.out.println(shuffleInts);
    }

    public static class ShuffleCollector<T> implements Collector<T, List<T>, List<T>> {
        private final Random random = new Random();

        @Override
        public Supplier<List<T>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<T>, T> accumulator() {
            return (list, value) -> {
                T oldValue;
                if (list.size() != 0) {
                    int randomIndex = random.nextInt(list.size());
                    oldValue = list.set(randomIndex, value);
                } else {
                    oldValue = value;
                }

                list.add(oldValue);
            };
        }

        @Override
        public BinaryOperator<List<T>> combiner() {
            return (list, list2) -> {
                list.addAll(list2);
                return list;
            };
        }

        @Override
        public Function<List<T>, List<T>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }
}