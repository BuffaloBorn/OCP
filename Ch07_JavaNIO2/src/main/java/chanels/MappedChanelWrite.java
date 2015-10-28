package chanels;

import OCP.App;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Created by vitaly on 28.10.15.
 */
public class MappedChanelWrite {
    public static void main(String[] args) throws IOException {
        try (FileChannel fChannel = (FileChannel)
                Files.newByteChannel(App.ROOT_PATH.resolve("writeTest.txt"),
                        StandardOpenOption.WRITE,
                        StandardOpenOption.READ,
                        StandardOpenOption.CREATE)) {

            MappedByteBuffer buffer = fChannel.map(FileChannel.MapMode.READ_WRITE, 0, fChannel.size());
            for (byte b = '0'; b < '9' + 1; b++) {
                buffer.put(b);
            }
        }

    }
}
