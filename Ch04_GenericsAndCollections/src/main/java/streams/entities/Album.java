/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package streams.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

/**
 * @author richard
 */
public final class Album implements Performance {

    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;
    private Integer year;

    public Album() {
        this("");
    }

    public Album(String name) {
        this(name, new ArrayList<>(), new ArrayList<>());
    }

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the tracks
     */
    public Stream<Track> getTracks() {
        return tracks.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<Track> getTrackList() {
        return unmodifiableList(tracks);
    }

    /**
     * @return the musicians
     */
    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<Artist> getMusicianList() {
        return unmodifiableList(musicians);
    }

    public Artist getMainMusician() {
        return musicians.get(0);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Album copy() {
        List<Track> tracks = getTracks().map(Track::copy).collect(toList());
        List<Artist> musicians = getMusicians().map(Artist::copy).collect(toList());
        return new Album(name, tracks, musicians);
    }

    private void addTrack0(Track track) {
        tracks.add(track);
    }

    public void addTrack(Track track) {
        addTrack0(track);
    }

    public void addTrack(String name, String length) {
        addTrack0(new Track(name, length));
    }


    public void addMusicians(Artist musician) {
        addMusicians0(musician);
    }

    private void addMusicians0(Artist musician) {
        musicians.add(musician);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(getMainMusician())
                .append(" - ")
                .append(name)
                .append("(")
                .append(year)
                .append(')');

        return sb.toString();
    }
}
