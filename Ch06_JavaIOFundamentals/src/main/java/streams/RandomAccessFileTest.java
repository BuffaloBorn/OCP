package streams;

import OCP.App;

import java.io.DataOutput;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Vitaly on 25.10.2015.
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {

        try(RandomAccessFile raf = new RandomAccessFile(App.ROOT_PATH_NAME + "raf.txt", "rw");) {
            raf.seek(raf.length());
            DataOutput out = raf;
            out.writeUTF("sdfsdf");
            out.writeDouble(10);
            out.writeInt(11);
        }
    }
}
