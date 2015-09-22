/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package streams.entities;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author richard
 */
public final class Track {
    private static Pattern TIME_VALIDATION_PATTERN = Pattern.compile("(\\d*:)?(\\d*:)?(\\d*)");
    private static Pattern SPLITTER = Pattern.compile(":");

    private final String name;
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Track(String name, String timeString) {
        this.name = name;
        this.length = parseTimeToSeconds(timeString);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the length of the track in milliseconds.
     */
    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name).append('(')
                .append(length)
                .append(")");

        return sb.toString();
    }

    private static int parseTimeToSeconds(String timeString) {
        Matcher valitation = TIME_VALIDATION_PATTERN.matcher(timeString);

        if (!valitation.matches()) {
            throw new IllegalArgumentException(timeString);
        }

        String[] parts = SPLITTER.split(timeString);
        int seconds = 0;

        for (int i = 1; i <= parts.length; i++) {
            seconds += Math.pow(60, i - 1) * Integer.parseInt(parts[parts.length - i]);
        }

        return seconds;
    }

}
