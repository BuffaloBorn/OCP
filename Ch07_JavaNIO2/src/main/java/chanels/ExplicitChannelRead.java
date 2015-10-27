package chanels;

import OCP.App;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by vitaly on 27.10.15.
 */
public class ExplicitChannelRead {
    public static void main(String[] args) {
        Path filePath = App.ROOT_PATH.resolve("Summary.txt");

        try (SeekableByteChannel channel = Files.newByteChannel(filePath)) {
            int byteCount;
            ByteBuffer buffer = ByteBuffer.allocate(64);
            do {

                byteCount = channel.read(buffer);
                if (byteCount != -1) {
                    buffer.rewind();
                    for (int i = 0; i < byteCount; i++) {
                        System.out.println((char) buffer.get());
                    }
                }

            } while (byteCount != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
