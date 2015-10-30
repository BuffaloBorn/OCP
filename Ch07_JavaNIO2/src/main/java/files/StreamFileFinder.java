package files;

import OCP.App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by vitaly on 30.10.15.
 */
public class StreamFileFinder {
    public static void main(String[] args) {
        try(Stream<Path> files = Files.find(App.ROOT_PATH, Integer.MAX_VALUE, (path, basicFileAttributes) -> true);
            Stream<Path> files2 = Files.walk(App.ROOT_PATH )){
//            files.forEach(System.out::println);
            System.out.println(files.count());
            System.out.println(files2.count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
