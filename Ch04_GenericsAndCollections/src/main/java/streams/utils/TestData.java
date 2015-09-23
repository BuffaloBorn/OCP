package streams.utils;

import streams.entities.Album;
import streams.entities.Artist;
import streams.entities.Track;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by vitaly on 21.09.15.
 */
public final class TestData {
    private static final List<Album> ALBUMS;
//    private static final List<Artist> ARTISTS;
    static {
        ALBUMS = createAlbums();
//        ARTISTS = ALBUMS.stream().flatMap()
    }
    private static List<Album> createAlbums() {
        List<Track> trackList;
        List<Album> albumList = new ArrayList<>();
        List<Artist> artistList;

        trackList = new ArrayList<>();
        trackList.add(new Track("Speak to Me", "1:30"));
        trackList.add(new Track("Breathe", "2:43"));
        trackList.add(new Track("On the Run", "3:36"));
        trackList.add(new Track("Time", "7:01"));
        trackList.add(new Track("Money", "6:22"));
        trackList.add(new Track("Us and Them", "7:46"));
        trackList.add(new Track("Any Colour You Like", "3:25"));
        trackList.add(new Track("Brain Damage", "3:48"));
        trackList.add(new Track("Eclipse", "2:03"));
//        trackList.add(new Track("", ""));

        artistList = new ArrayList<>();
        artistList.add(new Artist("Pink Floyd", toList("Великобритания", "Сид Барретт", "Роджер Уотерс", "Дэвид Гилмор", "Ричард Райт", "Ник Мэйсон"), "Великобритания"));

        Album album = new Album("The Dark Side of the Moon", trackList, artistList);
        album.setYear(1973);

        albumList.add(album);
        ///////////////////////////////////////////////////////////////////////////////
        album = new Album("Back in Black");
        album.setYear(1980);
        albumList.add(album);

        Artist artist = new Artist("AC/DC", "Австралия");
        album.addMusicians(artist);
        artist.addMember("Ангус Янг");
        artist.addMember("Клифф Уильямс");
        artist.addMember("Брайан Джонсон");
        artist.addMember("Стиви Янг");
        artist.addMember("Крис Слэйд");

        album.addTrack("Hells Bells", "5:12");
        album.addTrack("Shoot to Thrill", "5:17");
        album.addTrack("What Do You Do for Money Honey", "3:35");
        album.addTrack("Givin’ the Dog a Bone", "3:31");
        album.addTrack("Let Me Put My Love into You", "4:15");
        album.addTrack("Back in Black", "4:15");
        album.addTrack("You Shook Me All Night Long", "3:30");
        album.addTrack("Have a Drink on Me", "3:58");
        album.addTrack("Shake a Leg", "4:05");
        album.addTrack("Rock And Roll Ain’t Noise Pollution", "4:16");

        ///////////////////////////////////////////////////////////////////////////////
        album = new Album("Thriller");
        album.setYear(1982);
        albumList.add(album);

        artist = new Artist("Майкл Джексон", "США");
        album.addMusicians(artist);

        album.addTrack("Wanna Be Startin' Somethin'", "6:03");
        album.addTrack("Baby Be Mine (англ.)русск.", "4:20");
        album.addTrack("The Girl Is Mine", "3:42");
        album.addTrack("Thriller", "5:57");
        album.addTrack("Beat It", "4:18");
        album.addTrack("Billie Jean", "4:54");
        album.addTrack("Human Nature", "4:06");
        album.addTrack("P.Y.T. (Pretty Young Thing)", "3:59");
        album.addTrack("The Lady in My Life", "5:00");
                
        ///////////////////////////////////////////////////////////////////////////////
        album = new Album("The Bodyguard");
        album.setYear(1992);
        albumList.add(album);

        artist = new Artist("Уитни Хьюстон", "США");
        album.addMusicians(artist);

        album.addTrack("I Will Always Love You", "4:31");
        album.addTrack("I Have Nothing", "4:48");
        album.addTrack("I'm Every Woman", "4:45");
        album.addTrack("Run to You", "4:22");
        album.addTrack("Queen of the Night", "3:08");
        album.addTrack("Jesus Loves Me", "5:11");
        album.addTrack("Even If My Heart Would Break", "4:58");
        album.addTrack("Someday (I'm Coming Back)", "4:57");
        album.addTrack("It's Gonna Be a Lovely Day", "4:47");
        album.addTrack("(What's So Funny 'Bout) Peace, Love, and Understanding", "4:04");
        album.addTrack("Waiting for You", "4:58");
        album.addTrack("Trust in Me", "4:12");
        album.addTrack("Theme from The Bodyguard", "2:40");

        ///////////////////////////////////////////////////////////////////////////////
        album = new Album("Bat Out of Hell");
        album.setYear(1977);
        albumList.add(album);

        artist = new Artist("Meat Loaf", "США");
        album.addMusicians(artist);

        album.addTrack("Bat Out of Hell", "9:56");
        album.addTrack("You Took the Words Right Out of My Mouth (Hot Summer Night)", "5:04");
        album.addTrack("Heaven Can Wait", "4:38");
        album.addTrack("All Revved Up with No Place to Go", "4:19");
        album.addTrack("Two Out of Three Ain't Bad", "5:23");
        album.addTrack("Paradise by the Dashboard Light", "8:28");
        album.addTrack("For Crying Out Loud", "8:45");

        ///////////////////////////////////////////////////////////////////////////////
        album = new Album("Their Greatest Hits (1971–1975)");
        album.setYear(1976);
        albumList.add(album);

        artist = new Artist("Eagles", "США");
        album.addMusicians(artist);
        artist.addMember("Glenn Frey");
        artist.addMember("Don Henley");
        artist.addMember("Joe Walsh");
        artist.addMember("imothy B. Schmit");

        album.addTrack("Take It Easy", "3:29");
        album.addTrack("Witchy Woman", "4:10");
        album.addTrack("Lyin' Eyes", "6:21");
        album.addTrack("Already Gone", "4:13");
        album.addTrack("Desperado", "3:33");
        album.addTrack("One of These Nights", "4:51");
        album.addTrack("Tequila Sunrise", "2:52");
        album.addTrack("Take It to the Limit", "4:48");
        album.addTrack("Peaceful Easy Feeling", "4:16");
        album.addTrack("Best of My Love", "4:35");

        ///////////////////////////////////////////////////////////////////////////////
        album = new Album("Millennium");
        album.setYear(1999);
        albumList.add(album);

        artist = new Artist("Backstreet Boys", "США");
        album.addMusicians(artist);
        artist.addMembers("Брайан Литтрелл, Кевин Ричардсон, Ник Картер, Хауи Дороу, Эй Джей Маклин".split(", "));

        album.addTrack("Larger than life", "3:52");
        album.addTrack("I want it that way", "3:33");
        album.addTrack("Show me the meaning of being lonely", "3:54");
        album.addTrack("It's gotta be you", "2:56");
        album.addTrack("I need you tonight", "4:23");
        album.addTrack("Don’t want you back", "3:25");
        album.addTrack("Don’t wanna lose you now", "3:54");
        album.addTrack("The one", "3:46");
        album.addTrack("Back to your heart", "4:21");
        album.addTrack("Spanish eyes", "3:53");
        album.addTrack("No one else comes close", "3:42");
        album.addTrack("The perfect fan", "4:13");


        ///////////////////////////////////////////////////////////////////////////////
        album = new Album("Saturday Night Fever");
        album.setYear(1977);
        albumList.add(album);

        artist = new Artist("Bee Gees", "Великобритания");
        album.addMusicians(artist);
        artist.addMembers("Барри Гибб, Робин Гибб, Морис Гибб".split(", "));

        album.addTrack("Stayin\' Alive", "4:45");
        album.addTrack("How Deep Is Your Love", "4:05");
        album.addTrack("Night Fever", "3:33");
        album.addTrack("More Than a Woman", "3:17");
        album.addTrack("If I Can't Have You", "2:57");
        album.addTrack("A Fifth of Beethoven", "3:03");
        album.addTrack("More Than a Woman", "3:17");
        album.addTrack("Manhattan Skyline", "4:44");
        album.addTrack("Calypso Breakdown", "7:50");
        album.addTrack("Night on Disco Mountain", "5:12");
        album.addTrack("Open Sesame", "4:01");
        album.addTrack("Jive Talkin'", "3:43");
        album.addTrack("You Should Be Dancing", "4:14");
        album.addTrack("Boogie Shoes", "2:17");
        album.addTrack("Salsation", "3:50");
        album.addTrack("K-Jee", "4:13");
        album.addTrack("Disco Inferno", "10:51");



        ///////////////////////////////////////////////////////////////////////////////
        album = new Album("Rumours");
        album.setYear(1977);
        albumList.add(album);

        artist = new Artist("Fleetwood Mac", "Великобритания");
        album.addMusicians(artist);
        artist.addMembers("Питер Грин, Боб Браннинг, Денни Кируэн, Боб Уелч, Боб Уестон, Дейв Уокер, Билли Бёрнет, Рик Вито, Бекка Брамлет, Дейв Мэйсон".split(", "));

        album.addTrack("Second Hand News", "2:53");
        album.addTrack("Dreams", "4:14");
        album.addTrack("Never Going Back Again", "2:15");
        album.addTrack("Don't Stop", "3:12");
        album.addTrack("Go Your Own Way", "3:38");
        album.addTrack("Songbird", "3:21");
        album.addTrack("The Chain", "4:31");
        album.addTrack("You Make Loving Fun", "3:31");
        album.addTrack("I Don't Want To Know", "3:15");
        album.addTrack("Oh Daddy", "3:58");
        album.addTrack("Gold Dust Woman", "5:02");


//        ///////////////////////////////////////////////////////////////////////////////
//        album = new Album("");
//        albumList.add(album);
//
//        artist = new Artist("", "Великобритания");
//        album.addMusicians(artist);
//        artist.addMembers("".split(", "));
//
//        ///////////////////////////////////////////////////////////////////////////////
//        album = new Album("");
//        albumList.add(album);
//
//        artist = new Artist("", "Великобритания");
//        album.addMusicians(artist);
//        artist.addMembers("".split(", "));


        return albumList;
    }

    public static List<Artist> toList(String country, String... artistNames) {
        List<Artist> artistList = new ArrayList<>(artistNames.length);
        for (String artistName : artistNames) {
            artistList.add(new Artist(artistName, country));
        }

        return artistList;
    }

    public static List<Album> getAlbums() {
        return ALBUMS;
    }

    public static Stream<Album> getAlbumStream() {
        return getAlbums().stream();
    }

    public static void main(String[] args) {
//        List<Album> albums = getAlbums();
//        System.out.println(albums);
    }
}
