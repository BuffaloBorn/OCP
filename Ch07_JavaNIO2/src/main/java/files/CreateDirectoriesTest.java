package files;

import OCP.App;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * Created by vitaly on 29.10.15.
 */
public class CreateDirectoriesTest {
    public static void main(String[] args) throws IOException {
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-----");
        FileAttribute<Set<PosixFilePermission>> attrs = PosixFilePermissions.asFileAttribute(perms);
        Files.createDirectory(App.ROOT_PATH.resolve("test"), attrs);
        Files.createDirectories(App.ROOT_PATH.resolve("foo/bar/test"), attrs);

    }
}
