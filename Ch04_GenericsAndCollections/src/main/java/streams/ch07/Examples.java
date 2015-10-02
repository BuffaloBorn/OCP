package streams.ch07;

import org.junit.Test;
import streams.entities.Album;
import streams.entities.Artist;
import streams.entities.Track;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static streams.utils.TestData.getAlbumStream;
import static streams.utils.TestData.getAlbums;

/**
 * Created by vitaly on 24.09.15.
 */


public class Examples {
    //Тестируем весь метод с лямбдами
    @Test
    public void multipleWordsToUpperCase() {
        List<String> input = Arrays.asList("a b hello".split("\\W+"));
        List<String> test = Arrays.asList("A B HELLO".split("\\W+"));
        List<String> result = Testing.allToUpperCase(input);
        assertEquals(result, test);
    }

    //Тестируем приведение первой буквы слова в верхний регистр
    @Test
    public void capitalizingStringTest() {
        assertEquals("Ab", Testing.capitalizing("ab"));
        assertEquals("Ин", Testing.capitalizing("ин"));
        assertEquals(" ab", Testing.capitalizing(" ab"));
        assertEquals("", Testing.capitalizing(""));
    }

    @Test
    public void twinsTesting() {
        OrderDomain order = new OrderDomain(Arrays.asList(
                getAlbums().get(0),
                getAlbums().get(1),
                getAlbums().get(3),
                getAlbums().get(5)));
        assertEquals(4, order.conuntFeatures(album -> 1));

        long l = getAlbumStream().filter(album -> album.getYear() == 1977).peek(System.out::println).filter(album -> album.getName().charAt(0) == 'B').peek(System.out::println).count();
        System.out.println(l);
    }
}

class OrderDomain {
    private final List<Album> albums;

    OrderDomain(List<Album> albums) {
        this.albums = albums;
    }

    public long conuntFeatures(ToLongFunction<Album> mapper) {
        return albums.stream().mapToLong(mapper).sum();
    }

    public long countRunningTime() {
        return conuntFeatures(album -> album.getTracks().mapToLong(Track::getLength).sum());
    }

    public long countMusicants() {
        return conuntFeatures(album -> album.getMusicians().flatMap(Artist::getMembers).count());
    }

    public long countTracks() {
        return conuntFeatures(album -> album.getTracks().count());
    }
}

class Testing {
    public static List<String> allToUpperCase(List<String> words) {
        return words.stream().map(String::toUpperCase).collect(toList());
    }

    public static List<String> capitalizing(List<String> words) {
        return words.stream().map(Testing::capitalizing).collect(toList());
    }

    public static String capitalizing(String s) {
        Objects.requireNonNull(s);

        if (s.isEmpty()) {
            return s;
        }

        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}

