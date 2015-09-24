package streams.ch04;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import streams.entities.Album;
import streams.entities.Artist;
import streams.utils.TestData;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created by vitaly on 24.09.15.
 */
public class ArtistsTest extends TestCase {
    public Exercises.Artists artists;
    @Before
    public void setUp() throws Exception {
        List<Artist> artistList = TestData.getAlbumStream()
                .limit(4)
                .map(Album::getMainMusician)
                .collect(toList());

        artists = new Exercises.Artists(artistList);
    }

    @Test
    public void testGetArtist() throws Exception {
        assertTrue(artists.getArtist(0).isPresent());
        assertTrue(artists.getArtist(3).isPresent());
        assertFalse(artists.getArtist(-3).isPresent());
        assertFalse(artists.getArtist(4).isPresent());
        assertFalse(new Exercises.Artists(null).getArtist(4).isPresent());
    }

    @Test
    public void testGetArtistName() throws Exception {
        String unknown = "unknown";
        assertNotEquals(artists.getArtistName(0), unknown);
        assertNotEquals(artists.getArtistName(3), unknown);
        assertEquals(artists.getArtistName(-3), unknown);
        assertEquals(artists.getArtistName(4), unknown);
        assertEquals(new Exercises.Artists(null).getArtistName(4), unknown);
    }
}