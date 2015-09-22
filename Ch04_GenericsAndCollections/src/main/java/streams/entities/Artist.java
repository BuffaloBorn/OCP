/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package streams.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Domain class for a popular music artist.
 * 
 * @author Richard Warburton
 */
public final class Artist {
    
    private String name;
    private List<Artist> members;
    private String nationality;
    
    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the members
     */
    public Stream<Artist> getMembers() {
        return members.stream();
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }

    private void addMember0(Artist member) {
        members.add(member);
    }

    public void addMember(Artist member) {
        addMember0(member);
    }

    public void addMember(String name, String nationality) {
        addMember0(new Artist(name, nationality));
    }

    public void addMember(String name) {
        addMember0(new Artist(name, this.nationality));
    }

    public void addMembers(String... names) {
        for (String name : names) {
            addMember0(new Artist(name, this.nationality));
        }
    }


    @Override
    public String toString() {
        return getName();
    }

    public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(toList());
        return new Artist(name, members, nationality);
    }

}
