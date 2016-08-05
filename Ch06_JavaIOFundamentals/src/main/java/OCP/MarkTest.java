package OCP;

import java.io.*;

/**
 * Created by Vitaly on 03.08.2016.
 */
public class MarkTest {
    public static void main(String[] args) throws IOException {
        File file = new File("Ch06_JavaIOFundamentals\\src\\main\\resources\\smith\\data\\zoo.txt");
        try (InputStream is = new BufferedInputStream(new FileInputStream(file));) {
            System.out.println(is.markSupported());
            System.out.println((char) is.read());
            is.mark(0);
            System.out.println((char) is.read());
            System.out.println((char) is.read());
            System.out.println((char) is.read());
            System.out.println((char) is.read());
            System.out.println((char) is.read());
            is.reset();
            System.out.println((char) is.read());
            System.out.println((char) is.read());
            System.out.println((char) is.read());
            System.out.println((char) is.read());
            is.reset();
            System.out.println((char) is.read());

        }
    }
}
