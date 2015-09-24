package streams.ch03;

import streams.entities.Album;
import streams.entities.Artist;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.toList;
import static streams.utils.TestData.getAlbumStream;
import static streams.utils.TestData.getAlbums;

/**
 * Created by vitaly on 22.09.15.
 */
public class Exercises {
    public static int addUp(Stream<Integer> numbers) {
        return numbers.mapToInt(Integer::intValue).sum();
    }

    public static List<String> getMembersInfo(Artist artist) {
        Function<Artist, String> artistInfoMapper = a -> String.format("%s (%s)", a.getName(), a.getNationality());
        Stream<Artist> stream = artist.isSolo() ? Stream.of(artist) : artist.getMembers();

        return stream.map(artistInfoMapper).collect(toList());
    }

    public static <T,R> Stream<R> map(Stream<T> stream, Function<T, R> mapper) {
        List<R> result = new LinkedList<>();
        stream.reduce(((acc, element) -> {result.add(mapper.apply(element));
            return acc;}));
        return result.stream();
    }

    public static <T,R> Stream<R> map2(Stream<T> stream, Function<T, R> mapper) {
        return stream.reduce(new LinkedList<R>(),
                            (acc, element) -> {acc.add(mapper.apply(element)); return acc;
        }, (list, list2) -> list).stream();

    }

    public static <T> Stream<T> filter(Stream<T> stream, Predicate<T> predicate) {
        List<T> result = new LinkedList<>();
        stream.reduce(((acc, element) -> {if (predicate.test(element)) result.add(element);
            return acc;}));
        return result.stream();
    }

    public static void main(String[] args) {
//        1.
        Stream<Integer> numbers = Stream.of(1, 1, 1, 7);
        int sum = addUp(numbers);
        System.out.printf("Summ = %d\n", sum);

        System.out.println(getMembersInfo(getAlbums().get(2).getMainMusician()));

        List<Album> albumsLower5Tracks = getAlbumStream().filter(album -> album.getTracks().count() < 10).collect(toList());
        System.out.printf("Albums = %s\n", albumsLower5Tracks);

//        2.
        Collection<Artist> artists = Collections.emptyList();
        int totalMembers = (int) artists.stream().flatMap(Artist::getMembers).count();

//        6.
        String string = "asl;djfaSDgdsgasdgGsdgasIdgsGdgasdglkjs";
        long uppersCount = string.chars().filter(Character::isUpperCase).count();
        System.out.printf("Uppercased chars count=%s\n", uppersCount);

//        7
        List<String> strings = Arrays.asList("asldjfa sadfakjsdfla 111111111111asdfasdfa asdfas dfas dfasdfasdfa asdfasdfasdf".split("\\W+"));
        Optional<String> maxString = strings.stream().max(Comparator.comparing(String::length));
        System.out.printf("The biggest string is=%s\n", maxString);

//       8
        Stream<String> stream = strings.stream();
        List<Integer> integers = map2(stream, String::length).collect(toList());
        System.out.println(integers);

//        9
        stream = strings.stream();
        List<String> shortStrings = filter(stream, s -> s.length() < 10).collect(toList());
        System.out.println(shortStrings);
    }

}
