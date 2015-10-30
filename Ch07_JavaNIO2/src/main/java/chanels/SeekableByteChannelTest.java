package chanels;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;

/**
 * Created by vitaly on 29.10.15.
 */
public class SeekableByteChannelTest {
    public static void main(String[] args) {
//        try(SeekableByteChannel sbc = Files.newByteChannel(Paths.get("Ch07_JavaNIO2/src/main/resources/seekTest.txt"), READ, WRITE, CREATE)) {
//        try(SeekableByteChannel sbc = Files.newByteChannel(Paths.get("Ch07_JavaNIO2/src/main/resources/seekTest.txt"), WRITE, APPEND, DSYNC)) {
        try(SeekableByteChannel sbc = Files.newByteChannel(Paths.get("Ch07_JavaNIO2/src/main/resources/seekTest.txt"), CREATE, APPEND, DSYNC)) {
            sbc.position(sbc.size());
            ByteBuffer bb = ByteBuffer.allocate(102400);
            String encoding = System.getProperty("file.encoding");
            System.out.println(encoding);
            bb.put("Hello world!!!".getBytes());
            bb.flip();
            sbc.write(bb);
//            sbc.position(0);
//            bb.clear();
//            sbc.read(bb);
//            bb.flip();
//            CharBuffer charBuffer = Charset.defaultCharset().decode(bb);
//
//            charBuffer.chars().forEach(value -> System.out.print((char)value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
