package generics.exercises;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by vitaly on 11.09.15.
 */
public class Example {
    public static<T> int countIf(Collection<T> collection, Predicate<? super T> p) {
        int count = 0;
        for (T element : collection) {
            if (p.test(element)) {
                count++;
            }
        }
        return count;
    }

    public static <T> void swap(T[] array, T firstElement, T secondElement) {
        if (Objects.equals(firstElement, secondElement)
                || array == null
                || array.length < 2) {
            return;
        }

        T temp;
        Integer firstIndex = null, secondIndex = null;

        for (int i = 0; i < array.length && (firstIndex == null || secondIndex == null); i++) {
            if (firstIndex == null && Objects.equals(array[i], firstElement)) {
                firstIndex = i;
            }

            if (secondIndex == null && Objects.equals(array[i], secondElement)) {
                secondIndex = i;
            }
        }

        if (firstIndex != null && secondIndex != null) {
            temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;
        }
    }

    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    public static <T extends Comparable<T>> T maxInRange(List<T> list, int begin, int end) {
        return Collections.max(list.subList(begin, end));

    }
    public static <T extends Comparable<T>> T maxInRange2(List<T> list, int begin, int end) {
        T max = list.get(begin++);

        for (int i = begin; i < list.size(); i++) {
            T element = list.get(i);

            if (max.compareTo(element) > 0)
                max = element;
        }

        return max;

    }

    public static <T> T findFirst(List<T> list, int begin, int end, Predicate<T> p) {
        List<T> sublist = list.subList(begin, end);

        for (T elemetn :sublist) {
            if (p.test(elemetn)) {
                return elemetn;
            }
        }

        return null;
    }

    static class RelativelyPrimePredicate implements Predicate<Integer> {
        private final Collection<Integer> collection;

        RelativelyPrimePredicate(Collection<Integer> collection) {
            this.collection = collection;
        }

        @Override
        public boolean test(Integer integer) {
            for (Integer element : collection) {
                if (gcd(integer, element) != 1)
                    return false;
            }

            return true;
        }

        private int gcd(Integer x, Integer y) {
            for (int r; (r = x % y) != 0; x = y, y = r) { }
            return y;
        }
    }


    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        System.out.println(findFirst(li, 0, 8, new RelativelyPrimePredicate(li)));

        List<Integer> integers = new ArrayList<>();
        integers.add(15);
        integers.add(24);
        integers.add(9);
        integers.add(6);
        integers.add(64);

        List<Double> doubles = new ArrayList<>();
        integers.add(15);
        integers.add(24);
        integers.add(9);
        integers.add(6);
        integers.add(64);

        Predicate<Number> oddPredicate = number -> number.longValue() % 2 != 0;

        System.out.println(countIf(integers, oddPredicate));
        System.out.println(countIf(doubles, oddPredicate));
        System.out.println(Algorithm.max(new Date(), new Date()));
        Integer[] array = integers.toArray(new Integer[integers.size()]);
        System.out.println(Arrays.toString(array));
        swap(array, 24, 64);
        System.out.println(Arrays.toString(array));
        System.out.println(maxInRange(integers, 2, 5));

    }
}

final class Algorithm {
    public static <T extends Comparable<T>> T max(T x, T y) {
        return x.compareTo(y) > 0 ? x : y;
    }
}

class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }

class Node<T> { /* ... */
    public static void main(String[] args) {
        Node<Circle> nc = new Node<>();
//        Node<Shape>  ns = nc;
    }
}
