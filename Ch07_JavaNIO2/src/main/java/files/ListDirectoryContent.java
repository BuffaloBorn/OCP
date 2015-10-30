package files;

import OCP.App;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by vitaly on 29.10.15.
 */
public class ListDirectoryContent {
    public static void main(String[] args) throws IOException {
        try(DirectoryStream<Path> dirContent = Files.newDirectoryStream(App.ROOT_PATH);){
            dirContent.forEach(System.out::println);
        }
    }
}
