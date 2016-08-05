package OCP;

import print.PrintUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Vitaly on 04.08.2016.
 */
public class PathTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Path> paths = new ArrayList<>();
        paths.add(Paths.get("pandas", "cuddly.png"));
        paths.add(Paths.get("c:", "zooinfo", "November", "employees.txt"));
        paths.add(Paths.get("/", "home", "zoodirector"));
        paths.add(Paths.get("/"));

        paths.stream().map(Path::toAbsolutePath).forEach(System.out::println);
        paths.stream().map(Function.identity()).forEach(System.out::println);
        PrintUtils.printDelimiterString();

        FileSystem fs = FileSystems.getDefault();
        fs.getFileStores().forEach(System.out::println);
        PrintUtils.printDelimiterString();
        fs.getRootDirectories().forEach(System.out::println);
        PrintUtils.printDelimiterString();

//        PrintUtils.printSectionName("remote file system");
//        FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
        Path path = FileSystems.getDefault().getPath("duck.txt");
//        path.toRealPath(); //throws NoSuchFileException if file not exists
        System.out.println(Paths.get("/zoo/../home").getParent().normalize().toAbsolutePath());
        System.out.println(paths.get(0).toAbsolutePath());

        PrintUtils.printDelimiterString();
        for (Path p :path.toAbsolutePath()) {
            System.out.println(p.normalize());
        }

        PrintUtils.printDelimiterString();
        System.out.println(Paths.get("D:", "home").getFileName());
        PrintUtils.printDelimiterString();
        PrintUtils.printDelimiterString();
        PrintUtils.printDelimiterString();
        PrintUtils.printDelimiterString();


    }
}
