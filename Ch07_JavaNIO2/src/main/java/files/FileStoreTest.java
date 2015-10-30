package files;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by vitaly on 30.10.15.
 */
public class FileStoreTest {
    public static void main(String[] args) {
        FileSystems.getDefault().getFileStores().forEach(fileStore -> System.out.println(fileStore.name()));
    }
}
