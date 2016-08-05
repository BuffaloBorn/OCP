package OCP;

import print.PrintUtils;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Vitaly on 05.08.2016.
 */
public class StreamingPaths {
    public static Path workPath = Paths.get("D:\\Java\\OCP\\Ch07_JavaNIO2\\src\\main\\java\\OCP");
    public static Path rootPath = Paths.get("D:\\Java\\OCP");

    public static void main(String[] args) throws IOException {
        Files.walk(rootPath,  FileVisitOption.FOLLOW_LINKS).filter(path -> path.toString().endsWith(".java")).limit(5).forEach(System.out::println);
        PrintUtils.printDelimiterString();
        Files.list(Paths.get("D:\\Java\\OCP\\Errors.txt")).forEach(System.out::println);
    }

}
