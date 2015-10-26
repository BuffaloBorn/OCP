package OCP;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App
{
    public static final String ROOT_PATH = "Ch07_JavaNIO2/src/main/resources/";

    public static void main( String[] args ) {
        Path p01 = Paths.get("/home/vitaly");
//        Path p02 = Paths.get(URI.create("/home/vitaly/Загрузки/Master_snov [mbookz.net].txt"));
//        Path p03 = Paths.get(URI.create("file:///home/vitaly/Загрузки/Master_snov [mbookz.net].txt"));
        Path p04 = FileSystems.getDefault().getPath("/home/vitaly/Загрузки/Master_snov [mbookz.net].txt");
        Path p05 = Paths.get(System.getProperty("user.home"), "Загрузки", "Master_snov [mbookz.net].txt");
        Path p00 = p04;

        System.out.printf("toString: %s%n", p00.toString());
        System.out.printf("getFileName: %s%n", p00.getFileName());
        System.out.printf("getName(0): %s%n", p00.getName(0));
        System.out.printf("getNameCount(): %s%n", p00.getNameCount());
        System.out.printf("subpath(0, 1): %s%n", p00.subpath(0, 1));
        System.out.printf("getParent(): %s%n", p00.getParent());
        System.out.printf("getRoot(): %s%n", p00.getRoot());
//        System.out.printf(": %s%n", p05.);
        System.out.printf("%s%n", p00.getName(0));

//        NORMALIZE
        Path p06 = Paths.get("/home/sally/../joe/foo");
        System.out.println(p06);
        System.out.println(p06 = p06.normalize());

//        ABSOLUTE PATH
        Path p07 = Paths.get("log.txt");
        System.out.println(p07.toAbsolutePath());

//        Resolve
        System.out.println(p06.resolve("bar"));

//        Relative
        System.out.println(p04.relativize(p01));
        System.out.println(p01.relativize(p04));

        for (Path path : p00) {
            System.out.println(path);
        }

    }
}
