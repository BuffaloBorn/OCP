package OCP;

import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by Vitaly on 12.08.2016.
 */
public class Test {
    static Test boat;

    public static void main(String[] args) {
        try (AC a = new AC()) {
            System.out.println("T");
        } catch (Throwable e) {

        }
//        List<RuntimeException> l = bar();
//        new HashMap<Integer, String>().keySet().forEach(i->);
        LocalDateTime.now().toInstant(ZoneOffset.UTC);
        System.out.println(Paths.get("/zoo").resolve(Paths.get("\\1/zoo")));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, null);
        BiFunction<Integer, Integer, Integer>f = (x, y) -> {return null;};


        map.merge(1, 1, f);
        map.merge(2, 1, f);
        System.out.println(map);
        List<? extends String> l = new ArrayList();
//        Collections.sort(new ArrayList<AC>());
    }

    public static List<? super Exception> bar() {
        return new ArrayList<Throwable>();
    }
    public static void foo(List<String> list) {

    }
}

class AC implements AutoCloseable {
    @Override
    public void close()  {

    }
}