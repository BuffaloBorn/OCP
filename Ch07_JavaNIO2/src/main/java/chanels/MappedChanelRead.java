package chanels;

import OCP.App;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * Created by Vitaly on 27.10.2015.
 */
public class MappedChanelRead {
    public static void main(String[] args) {
        try (FileChannel channel = (FileChannel) Files.newByteChannel(App.SUMMARY_PATH)) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
//            MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
//            CharBuffer buffer = buf.asCharBuffer();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
