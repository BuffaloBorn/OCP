package OCP;

import java.io.*;

/**
 * Created by Vitaly on 03.08.2016.
 */
public class CopyFiles {
    public static void copy(File src, File dst) throws IOException {
        try (InputStream is = new FileInputStream(src);
             OutputStream os = new FileOutputStream(dst);) {
            int data;
            while ((data = is.read()) != -1) {
                os.write(data);
            }
        }
    }
    public static void copy2(File src, File dst) throws IOException {
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dst));) {

            int dataSize;
            byte[] data = new byte[1024];
            while ((dataSize = is.read(data))>0) {
                os.write(data, 0, dataSize);
                os.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        copy2(new File("D:\\Java\\OCP\\Ch06_JavaIOFundamentals\\src\\main\\java\\OCP\\App.java"), new File("D:/Java/OCP/Ch06_JavaIOFundamentals/src/main/java/OCP\\AppCopy.java"));
    }
}
