package streams.ch05;

import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created by vitaly on 24.09.15.
 */

public class Examples {
    @Test
    public void main() {
        List<Integer> numbersUnsorted = Arrays.asList(4, 5, 1, 3, 2, 6);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> sameOrder = numbers.stream().collect(toList());
        List<Integer> hashOrder = new HashSet<>(numbersUnsorted).stream().collect(toList());
        List<Integer> sorted = numbersUnsorted.stream().sorted().collect(toList());

        assertEquals(numbers, sameOrder);
        assertNotEquals(numbersUnsorted, hashOrder);
        assertEquals(numbers, sorted);
    }
}
