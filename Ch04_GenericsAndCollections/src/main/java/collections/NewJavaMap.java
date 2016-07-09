package collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Vitaly on 17.06.2016.
 */
public class NewJavaMap {
    public static void main(String[] args) {
        removeIf();

        replaceAll();

        Map<Integer, String> map = getSimpleMap();
        System.out.println(map);

        //Compute
        map.compute(6, (integer, s) -> "Vlad");
        System.out.println(map);
        map.compute(5, (integer, s) -> null);
        System.out.println(map);

        marge();
    }

    private static void marge() {
        String s = ";sdjfasuiwnwg s foiawhfaw fa sdflja fjals flas jdfoiawj flajs flsa jflkasj foijwaiefj";
        Map<Character, Integer> map = new HashMap<>();

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            map.merge(c, 1, (i1, i2) -> i1 + i2);
        }

        System.out.println(map);
    }

    public static Map<Integer, String> getSimpleMap() {

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Vitaly");
        map.put(2, "Roma");
        map.put(3, "Anna");
        map.put(4, "Dasha");
        map.put(5, null);

        return map;
    }

    public static void replaceAll() {
        List<Integer> integers = IntStream.iterate(1, i -> i + 1).limit(5).boxed().collect(Collectors.toList());
        System.out.println(integers);
        integers.replaceAll(i -> i * i);
        System.out.println(integers);
    }

    public static void removeIf() {
        List<String> list = new ArrayList<>();
        list.add("Magician");
        list.add("Assistant");
        System.out.println(list);  // [Magician, Assistant]
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list);  // [Magician]
    }
}
