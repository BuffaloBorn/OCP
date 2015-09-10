package OCP;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        processStringList(Collections.emptyList());
        Predicate<String> p = s -> s.isEmpty();
    }

    public static void processStringList(List<String> stringList) {
        // process stringList
    }
}
