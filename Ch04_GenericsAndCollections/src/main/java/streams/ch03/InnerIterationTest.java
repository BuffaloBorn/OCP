package streams.ch03;

import streams.entities.Album;
import streams.utils.TestData;

import java.util.Iterator;

/**
 * Created by vitaly on 22.09.15.
 */
public class InnerIterationTest {
    public static void main(String[] args) {

        Album a = null;
        for (Iterator<Album> i = TestData.getAlbums().iterator(); i.hasNext(); a = i.next()) {
            if (a != null && a.getMainMusician().isFrom("США")) {
                System.out.println(a);
            }
        }

        System.out.println("------------------------------------------------------------------------");

        TestData.getAlbums().stream()
                .filter(album -> !album.getMainMusician().isFrom("США"))
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");

        TestData.getAlbums().stream()
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------");

        long count = TestData.getAlbums().stream()
            .filter(album -> {
                System.out.println("filter1");
                return album.getYear() == 1977;})
            .filter(album -> {
                System.out.println("filter2");
                return album.getMainMusician().isSolo();})
                .count();

        System.out.println("------------------------------------------------------------------------");

        System.out.println(count);
    }
}
