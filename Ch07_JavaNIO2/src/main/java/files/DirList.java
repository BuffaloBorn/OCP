package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

/**
 * Created by vitaly on 28.10.15.
 */
public class DirList {
    public static final Consumer<Path> PATH_PRINTER = path -> {
        String suffix = Files.isDirectory(path) ? "<DIR>" : "    ";
        System.out.printf("%-40s\t%s%n", path, suffix);
    };



    public static void main(String[] args) throws IOException {
        final Path dir = Paths.get("");
        DirectoryStream<Path> paths = Files.newDirectoryStream(dir, "{.*,*_*}");
        paths.forEach(PATH_PRINTER);

        System.out.println("=======================================");

        DirectoryStream<Path> paths2 = Files.newDirectoryStream(dir, entry -> Files.isDirectory(entry));
        paths2.forEach(PATH_PRINTER);

        System.out.println("=======================================");


        Files.list(dir).forEach(PATH_PRINTER);
    }
}
