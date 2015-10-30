import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by vitaly on 30.10.15.
 */
public class PathsTest {
    public static void main(String[] args) {
        Path vitaly = Paths.get("//home/vitaly");
        Path root = Paths.get("/");
        Path dev = Paths.get("//home/dev");
        Path downloads = Paths.get("home/Загрузки");
        Path abc = Paths.get("a/b/c");
        Path fooBar = Paths.get("/foo/bar/");
        System.out.println(vitaly.relativize(dev));
//        System.out.println(vitaly.relativize(downloads)); //ERROR
        System.out.println(vitaly.relativize(root));
        System.out.println(dev.normalize());
        System.out.println(dev.relativize(fooBar));
        System.out.println(abc.relativize(downloads));
        System.out.println(downloads.resolve("../../../..").normalize());
//        System.out.println(downloads.relativize(vitaly));
    }
}
