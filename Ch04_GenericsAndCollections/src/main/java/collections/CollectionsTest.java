package collections;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Vitaly on 13.09.2015.
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 5, 8, 6, 7, 3, 5, 8, 2, 4, 8, 2, 4);
        System.out.println(list);
        Collections.replaceAll(list, 8, 0);
        System.out.println(list);
        Collections.rotate(list, -2);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        Collection<String> strings = Pattern.compile("\\W+").splitAsStream("a g s gl e df r fis slf g b f d h d  s h s s g s s s g sgdfsls s s gs").collect(Collectors.toCollection(LinkedList::new));
        System.out.printf("String collection: %s\n", strings);
        //Создаем коллекцию на основании предыдущей клддекции без букв s
        Collection withoutSStrings = strings.stream().filter(s -> !s.equalsIgnoreCase("s")).collect(Collectors.toList());
        System.out.printf("String collection2: %s\n", withoutSStrings);
        System.out.printf("String collection: %s\n", strings);

        //Удаляем из текущей коллекции все буквы s
        strings.removeAll(Collections.singleton("s"));
        System.out.printf("String collection after bulk removing: %s\n", strings);
        strings.removeIf(s -> s.contains("s"));
        System.out.printf("String collection predicate removing: %s\n", strings);

        List<Integer> integers = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        Number[] numbersArray = new Number[integers.size()];
        integers.toArray(numbersArray);
        numbersArray[0] = 4.8;
        System.out.println(Arrays.toString(numbersArray));
    }
}
