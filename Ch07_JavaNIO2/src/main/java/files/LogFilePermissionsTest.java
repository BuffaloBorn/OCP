package files;

import OCP.App;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

import static java.nio.file.StandardOpenOption.*;

/**
 * Created by vitaly on 29.10.15.
 */
public class LogFilePermissionsTest {
    public static void main(String[] args) {
        Set<OpenOption> options = new HashSet<>();
        options.add(APPEND);
        options.add(CREATE);

        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);

        String s = "Hello Ukraine!!!";
        byte[] data = s.getBytes();
        ByteBuffer bb = ByteBuffer.wrap(data);

        try(SeekableByteChannel sbc = Files.newByteChannel(App.ROOT_PATH.resolve("permissions.log"), options, attr);) {
            sbc.write(bb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
