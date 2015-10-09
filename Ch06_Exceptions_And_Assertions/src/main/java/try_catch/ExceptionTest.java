package try_catch;

import sun.font.TrueTypeFont;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by vitaly on 09.10.15.
 */
public class ExceptionTest {
//    1. True
//    2.
    public static void main(String[] args) {
//        InputStream stream;
        try (MockAutoClocable clocable = new MockAutoClocable();
             MockAutoClocable clocable1 = new MockAutoClocable()) {
            throw new NullPointerException();
//            stream = is;
//            throw new UnsupportedOperationException();
        } catch (Exception e) {
//            final RuntimeException exception = new RuntimeException(e);
//            System.out.println(e.getSuppressed().getClass());
//            throw exception;
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
        }
//        try {
//            stream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        };
    }
}

class MockAutoClocable implements AutoCloseable {
    public MockAutoClocable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() throws Exception {
        throw new IllegalArgumentException();
    }
}