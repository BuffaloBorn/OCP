package streams.ch03;

import streams.entities.Album;
import streams.entities.Artist;
import streams.entities.Track;
import streams.utils.TestData;
import static streams.utils.TestData.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import static java.util.stream.Collectors.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vitaly on 22.09.15.
 */
public class InnerIterationTest {
    public static void main(String[] args) {

        Album a = null;
        for (Iterator<Album> i = getAlbums().iterator(); i.hasNext(); a = i.next()) {
            if (a != null && a.getMainMusician().isFrom("США")) {
                System.out.println(a);
            }
        }

        System.out.println("------------------------------------------------------------------------");

        getAlbums().stream()
                .filter(album -> !album.getMainMusician().isFrom("США"))
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");

        getAlbums().stream()
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");

        long count = getAlbums().stream()
            .filter(album -> {
                System.out.println("filter1");
                return album.getYear() == 1977;
            })
            .filter(album -> {
                System.out.println("filter2");
                return album.getMainMusician().isSolo();
            })
                .count();

        System.out.println("------------------------------------------------------------------------");

//        collect
        Optional<Integer> maxYear = getAlbumStream().map(Album::getYear).collect(maxBy(Comparator.naturalOrder()));
        System.out.printf("Max year: %s\n", maxYear);

        Set<Integer> yearsSet = getAlbumStream().map(Album::getYear).collect(toSet());
        System.out.printf("Year set: %s\n", yearsSet);

        List<Integer> yearList = getAlbumStream().map(Album::getYear).collect(toList());
        System.out.printf("Year list: %s\n", yearList);

        Set<Character> characterSet = ";aljsdf;lasjf;asjdf;asjf;asjf;asj".chars().mapToObj(c -> (char) c).collect(toSet());
        System.out.printf("Character set: %s\n", characterSet);

        List<Character> characterList = ";aljsdf;lasjf;asjdf;asjf;asjf;asj".chars().distinct().mapToObj(value -> (char) value).collect(toList());
        System.out.printf("Character list: %s\n", characterList);

        System.out.println("------------------------------------------------------------------------");

//        map
        List<String> lowerCasedStrings = Arrays.asList("f dfd lkjioj aeafaef hesso    hello ender".split("\\W+"));
        System.out.printf("Lower cased string list: %s\n", lowerCasedStrings);
        UnaryOperator<String> mapper = s -> Character.toUpperCase(s.charAt(0)) + s.substring(1);
        List<String> capitalizedStrings = lowerCasedStrings.stream().map(mapper).collect(toList());
        System.out.printf("Capitalized string list: %s\n", capitalizedStrings);
        int[] ints = lowerCasedStrings.stream().mapToInt(String::length).toArray();
        System.out.printf("length array: %s\n", Arrays.toString(ints));

        System.out.println("------------------------------------------------------------------------");

//        filter
        List<Artist> soloArtists = getAlbumStream().filter(album -> album.getMainMusician().isSolo()).map(Album::getMainMusician).collect(toList());
        System.out.printf("Solo artist list: %s\n", soloArtists);
        System.out.println("------------------------------------------------------------------------");

//        flatMap
        Function<Album, Stream<Artist>> artistMapper = album -> {
            return album.getMusicians().flatMap(artist -> {
                return artist.isSolo() ? Stream.of(artist) : artist.getMembers();
            });
        };

        List<Artist> allArtists = getAlbumStream().flatMap(artistMapper).collect(toList());
        System.out.printf("All artist list: %s\n", allArtists);
        System.out.println("------------------------------------------------------------------------");

//        min/max
        Comparator<Album> yearComparator = Comparator.comparingInt(Album::getYear);
        Comparator<Album> trackCountComparator = Comparator.comparingLong(album -> album.getTracks().mapToLong(Track::getLength).sum());
        Comparator<Album> comparator = trackCountComparator;
        Album min = getAlbumStream().min(comparator).get();
        Album max = getAlbumStream().min(comparator.reversed()).get();
        System.out.printf("Min albom = %s\nMax albom = %s\n", min, max);
        System.out.println("------------------------------------------------------------------------");

        //reduce
        int totalLength = getAlbumStream().flatMap(Album::getTracks).mapToInt(Track::getLength).reduce(0, (acc, element) -> acc + element);
        IntSummaryStatistics statistic = getAlbumStream().flatMap(Album::getTracks).mapToInt(Track::getLength).summaryStatistics();

        System.out.printf("Total library length = %d\n", totalLength);
        System.out.printf("Statistic = %s\n", statistic.toString());

        System.out.println("------------------------------------------------------------------------");
    }
}
