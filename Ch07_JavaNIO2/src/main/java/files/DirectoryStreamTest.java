package files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by vitaly on 30.10.15.
 */
public class DirectoryStreamTest {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/vitaly/IdeaProjects/OCP/Ch07_JavaNIO2/src/main/java/files");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, "D*");) {
            directoryStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
