import com.sun.org.glassfish.external.statistics.AverageRangeStatistic;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.Math.*;

/**
 * Created by vitaly on 06.10.15.
 */
public class Exercises {
    //    1. Write a program that prints its arguments in random order. Do not make a copy of
//          the argument array. Demonstrate how to print out the elements using both streams and the traditional enhanced for statement.
    public static void shuffle(String... args) {
        class ShuffleCollector<T> implements Collector<T, List<T>, List<T>> {
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
        Random r = new Random();
        Collector<String, List<String>, List<String>> collector = new ShuffleCollector<String>();

        List<String> stringsShuffle = Arrays.stream(args).collect(collector);
        Collections.shuffle(Arrays.asList(args));
        System.out.println(stringsShuffle);
        System.out.println(Arrays.toString(args));

    }

    //    Take the FindDupsexample and modify it to use a SortedSet instead of a Set. Specify a Comparator so that case is ignored when sorting and identifying set elements.
    public static SortedSet<String> findDups(String... args) {
        final Comparator<String> comparator = Comparator.nullsFirst(String::compareToIgnoreCase);
        final TreeSet<String> strings = new TreeSet<>(comparator);
        Collections.addAll(strings, args);

        return strings;
    }

    //    Write a method that takes a List<String> and applies String.trim to each element.
    public static List<String> trimmer(Collection<String> stringCollection) {

        return stringCollection.stream().map(String::trim).collect(Collectors.toList());

    }

    public static <T> void modifier(List<T> list, UnaryOperator<T> action) {

        for (ListIterator<T> listIterator = list.listIterator(); listIterator.hasNext(); ) {
            listIterator.set(action.apply(listIterator.next()));
        }

    }

    public static void trimmer(List<String> list) {
        modifier(list, String::trim);
    }

//    Consider the four core interfaces, Set, List, Queue, and Map. For each of the following four assignments, specify which of the four core interfaces is best-suited, and explain how to use it to implement the assignment.
//    Whimsical Toys Inc (WTI) needs to record the names of all its employees. Every month, an employee will be chosen at random from these records to receive a free toy. (List если выбор идет в случайном порядке нужен произвольный доступ к элементам)
//    WTI has decided that each new product will be named after an employee but only first names will be used, and each name will be used only once. Prepare a list of unique first names. (Set потому что список должен быт уникальный)
//    WTI decides that it only wants to use the most popular names for its toys. Count up the number of employees who have each first name. (Map потому что нужно группировать значения)
//    WTI acquires season tickets for the local lacrosse team, to be shared by employees. Create a waiting list for this popular sport. (Queue потому что нужно выстроить очередь)

    public static void main(String[] args) {
        String[] sortedStrings = IntStream.range('A', 'Z' + 1).mapToObj(value -> String.valueOf((char) value)).toArray(String[]::new);
        String[] duplicateStrings = new Random().ints(10, 'A', 'A' + 10).mapToObj(value -> String.valueOf((char) value)).toArray(String[]::new);
        System.out.println(Arrays.toString(sortedStrings));
        shuffle(sortedStrings);
        System.out.println(findDups(duplicateStrings));
        int max = Arrays.asList(1, 4, 5, 6, 6, 3).stream().reduce((a, b) -> a > b ? a : b).get();
        System.out.println(max);
        max = Arrays.asList(1, 4, 5, 7, 6, 3).stream().max(Integer::max).get();
        System.out.println(max);

        final List<Integer> integers = Arrays.asList(1, 4, 5, 7, 6, 3);
        System.out.println(integers);
        System.out.println(integers.stream().findFirst().get());
        System.out.println(integers.stream().findAny().get());
        System.out.println(integers.stream().allMatch(integer -> integer == 1));
        System.out.println(integers.stream().anyMatch(integer -> integer % 2 == 0));
        System.out.println(integers.stream().noneMatch(integer -> integer == 3));
        IntSummaryStatistics statistic = integers.stream().mapToInt(Integer::intValue).summaryStatistics();
        IntStream.rangeClosed(1, 3).forEach(System.out::print);
        IntStream.range(1, 3).forEach(System.out::print);
//        Map<Integer, Imap = integers.stream().collect(Collectors.groupingByConcurrent(EnumMap, Collectors.toList()));
//        System.out.println(integers.stream().noneMatch(integer -> integer == 3));

//        String s = "012345";
//        s.substring(2);
//        System.out.println(s);
//
//        s = "asdf as;dfas df asdf  as df a sd f as d f  g dfh r j     jf gj f  ffjd;fg;j;;df  gfghjrt";
//        System.out.println(Arrays.asList(s.split(" ")));
//        final int matrixSize = 15;
//        int value = 0;
//        for (int i = 0; i < matrixSize; i++) {
//            for (int j = 0; j < matrixSize; j++) {
//                System.out.printf("%0" + (int)(log10( pow(matrixSize, 2)) + 1) + "d\t", value++);
//            }
//            System.out.println();
//        }

//        int a = 3 / 2;
//        long l = 6;
//        a = a / l;
//        foo(5);
//        byte b1 = 1 + 1;
//        byte b2 = b1 + 1;

    }

    public static void foo(byte b) {}
//
//    public static void foo(float f) {
//
//    }

}
