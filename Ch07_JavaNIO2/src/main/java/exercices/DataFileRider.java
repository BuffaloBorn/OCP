package exercices;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import static java.nio.file.StandardOpenOption.*;

/**
 * Created by vitaly on 30.10.15.
 */
public class DataFileRider {
    public static final String fileName = "/home/vitaly/IdeaProjects/OCP/Ch07_JavaNIO2/src/main/resources/data.dat";

    public static void main(String[] args) {
        fillData();
        readData();
    }

    private static void readData() {
        try(FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get(fileName));) {
            ByteBuffer bb = ByteBuffer.allocate(8);

            channel.read(bb);
            long dataAddress = bb.getLong(0);
            System.out.println(dataAddress);

            channel.position(dataAddress * 4);
            bb.rewind();
            channel.read(bb);
            System.out.println(bb.getInt(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillData() {
        try(ByteChannel channel =  Files.newByteChannel(Paths.get(fileName), CREATE, WRITE);) {
            ByteBuffer bb = ByteBuffer.allocate(1024 * 4);
            Random random = new Random();

            long dataAddress = new Random().nextInt(1024);
            System.out.println(dataAddress);
            bb.putLong(dataAddress);

            for (int i = 2; bb.hasRemaining(); i++) {
                int data = random.nextInt();
//                int data = i - 2;

                if (i == dataAddress) {
                    System.out.println(data);
                }
                bb.putInt(data);
            }

            bb.flip();
            channel.write(bb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
