package files;

import OCP.App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by vitaly on 29.10.15.
 */
public class TempFileCreation {
    public static void main(String[] args) throws IOException {
        Path tmp = Files.createTempFile(App.ROOT_PATH, null, ".tmp");
    }
}
