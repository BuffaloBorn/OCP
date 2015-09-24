package streams.ch04;

import streams.entities.Album;
import streams.entities.Artist;
import streams.entities.Performance;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static streams.utils.TestData.getAlbumStream;
import static streams.utils.TestData.getAlbums;

/**
 * Created by vitaly on 22.09.15.
 */
public class Exercises {
    public static class Concert implements Performance {
        private String name;
        private List<Artist> artists;

        public Concert() {
            this(null, new LinkedList<>());
        }

        public Concert(String name) {
            this(name, new LinkedList<>());
        }

        public Concert(String name, List<Artist> artists) {
            this.name = name;
            this.artists = artists;
        }

        @Override
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public Stream<Artist> getMusicians() {
            return artists.stream().flatMap(artist -> artist.isSolo() ? Stream.of(artist) : Stream.concat(Stream.of(artist), artist.getMembers()));
        }

        private void addArtist0(Artist artist) {
            artists.add(artist);
        }

        public void addArtist(Artist artist) {
            addArtist0(artist);
        }

        public void addArtist(String artistName, String artistNationality) {
            addArtist0(new Artist(artistName, artistNationality));
        }
    }

    public static class Artists {
        private List<Artist> artists;

        public Artists(List<Artist> artists) {
            this.artists = artists;
        }

        public Optional<Artist> getArtist(int index) {
            if (artists == null || index < 0 || index >= artists.size()) {
                return Optional.empty();
            } else {
                return Optional.of(artists.get(index));
            }
        }

        public String getArtistName(int index) {
            return  getArtist(index).map(Artist::getName).orElse("unknown");
        }
    }

    public static void main(String[] args) {
//        1
        Concert concert = new Concert("Rock Fest 2015");
        concert.addArtist(getAlbums().get(0).getMainMusician());
        concert.addArtist(getAlbums().get(1).getMainMusician());
        concert.addArtist(getAlbums().get(2).getMainMusician());
        System.out.println(concert.getMusicians().collect(toList()));

//        2
//        3
//        4
//        5
//        6
//        7
//        8
//        9
    }
}
