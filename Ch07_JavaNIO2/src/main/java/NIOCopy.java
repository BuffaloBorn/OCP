import OCP.App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by vitaly on 28.10.15.
 */
public class NIOCopy {
    public static void main(String[] args) {
        try {
            Path source = App.SUMMARY_PATH;
            Path target = App.SUMMARY_PATH.getParent().resolve("Summary.copy");

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
