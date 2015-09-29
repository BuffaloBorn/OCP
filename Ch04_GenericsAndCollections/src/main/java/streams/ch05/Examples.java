package streams.ch05;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import streams.entities.Album;
import streams.entities.Artist;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;
import static streams.utils.TestData.getAlbumStream;
import static streams.utils.TestData.getAlbums;

/**
 * Created by vitaly on 24.09.15.
 */

public class Examples {
    public List<Integer> numbersUnsorted = Arrays.asList(4, 5, 1, 3, 2, 6);
    public List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

//    public static void main(String[] args) {
//        String artistNames = getAlbums().get(0).getMainMusician().getMembers().map(Artist::getName).collect(stringCollector(":", "(", ")"));
//        System.out.println(artistNames);
//    }
    @Test
    public void main() {

        List<Integer> sameOrder = numbers.stream().collect(toList());
        List<Integer> hashOrder = new HashSet<>(numbersUnsorted).stream().collect(toList());
        List<Integer> sorted = numbersUnsorted.stream().sorted().collect(toList());

        assertEquals(numbers, sameOrder);
        assertNotEquals(numbersUnsorted, hashOrder);
        assertEquals(numbers, sorted);

        List<Integer> integerList = IntStream.range(0, numbersUnsorted.size()).mapToObj(numbersUnsorted::get).collect(toList());
        System.out.println(integerList);


    }

    @Test
    public void collectors() {
//        System.out.println(getAlbums());
        HashSet<Integer> intSet = numbersUnsorted.stream().collect(toCollection(HashSet::new));
        assertEquals(intSet, new HashSet<Integer>(numbersUnsorted));

        Album lastAlbum = getAlbumStream().collect(maxBy(comparingInt(Album::getYear))).get();
        assertEquals(getAlbums().get(6), lastAlbum);

        Map<Boolean, List<Album>> albumMap = getAlbumStream()
                .collect(partitioningBy(album -> album.getMainMusician().isSolo()));
        System.out.println(albumMap);
        System.out.println();

        Map<Integer, List<Album>> albumsByYears = getAlbumStream()
                .collect(groupingBy(Album::getYear));
        System.out.println(albumsByYears);
        System.out.println();

        String artists = getAlbums().get(0).getMainMusician().getMembers().map(Artist::getName).collect(joining(", ", "{", "}"));
        System.out.println(artists);

        Map<Integer, Long> albumsByYearsCount = getAlbumStream()
                .collect(groupingBy(Album::getYear, counting()));
        System.out.println(albumsByYearsCount);
        System.out.println();

        Map<Integer, List<String>> albums = getAlbumStream().collect(groupingBy(Album::getYear, mapping(Album::getName, toCollection(LinkedList::new))));
        System.out.println(albums);
        System.out.println();

        String artistNames = getAlbums().get(0).getMainMusician().getMembers().map(Artist::getName).collect(stringCollector(":", "(", ")"));
        System.out.println(artistNames);


    }

    private static class Combiner implements BinaryOperator<StringBuilder> {

        @Override
        public StringBuilder apply(StringBuilder sb1, StringBuilder sb2) {
            int i = 0 + 7;
            return sb1.append(sb2);
        }
    }
    public static Collector<String, StringBuilder, String> stringCollector(String delimiter, String prefix, String suffix) {
        return new Collector<String, StringBuilder, String>() {
            @Override
            public Supplier<StringBuilder> supplier() {
                return StringBuilder::new;
            }

            @Override
            public BiConsumer<StringBuilder, String> accumulator() {

                return (sb, s) -> {
                    if (sb.length() > 1) {
                        sb.append(delimiter);
                    }
                    sb.append(s);

                };
            }

            @Override
            public BinaryOperator<StringBuilder> combiner() {
                return null;
//                return (stringBuilder, stringBuilder2) -> stringBuilder;
//                return new Combiner();
//                return (sb1, sb2) -> {
//                    int i = 0;
//                    return sb1.append(sb2);
//                };
            }
            //Бренди Виски, Гектор, Гелий, Изюм, Зевс, Изя, Крис, Крон, Круз, Марс, Барт, Бакс, Оскар, Гарфилд, Феликс, Рубин, Бус

            @Override
            public Function<StringBuilder, String> finisher() {
                return sb -> {
                    sb.insert(0, prefix);
                    sb.append(suffix);
                    return sb.toString();
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        };
    }
}
