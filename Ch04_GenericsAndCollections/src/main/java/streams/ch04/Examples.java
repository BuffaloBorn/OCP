package streams.ch04;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
/**
 * Created by vitaly on 24.09.15.
 */

public class Examples {
    @Test
    public void main() {
        Optional<String> a = Optional.of("a");
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);
        assertEquals("a", a.get());
        assertFalse(emptyOptional.isPresent());
        assertTrue(a.isPresent());
//        assertNull(alsoEmpty.get());
        assertNotNull(emptyOptional.orElse("Null"));
    }
}
