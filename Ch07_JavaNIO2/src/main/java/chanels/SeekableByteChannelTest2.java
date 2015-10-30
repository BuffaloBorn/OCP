package chanels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

/**
 * Created by vitaly on 29.10.15.
 */
public class SeekableByteChannelTest2 {
    public static void main(String[] args) {
        String s = "I was here!";
        try (SeekableByteChannel sbc = Files.newByteChannel(Paths.get("Ch07_JavaNIO2/src/main/resources/seekTest.txt"), READ, WRITE, CREATE)) {
            sbc.position(10);
            ByteBuffer bb = ByteBuffer.wrap(s.getBytes());
            String encoding = System.getProperty("file.encoding");
            System.out.println(encoding);
//            bb.put("Hello world!!!".getBytes());
//            bb.flip();
            sbc.write(bb);
            sbc.position(sbc.size());
            sbc.write((ByteBuffer) bb.flip());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
