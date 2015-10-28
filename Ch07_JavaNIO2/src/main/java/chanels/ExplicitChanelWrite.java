package chanels;

import OCP.App;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Created by Vitaly on 27.10.2015.
 */
public class ExplicitChanelWrite {
    public static void main(String[] args) {
        try(FileChannel fChannel = (FileChannel)
                Files.newByteChannel(App.ROOT_PATH.resolve("writeTest.txt"),
                        StandardOpenOption.WRITE,
//                        StandardOpenOption.APPEND,
                        StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocate(27);
            for (byte i = 'a'; i < 'z' + 1; i++) {
                buffer.put(i);
            }

            buffer.put((byte) '\n');

            for (int h = 0; h < 3; h++) {
                buffer.rewind();
                fChannel.write(buffer);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
