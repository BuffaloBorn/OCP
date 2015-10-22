package streams;

import java.io.*;

/**
 * Created by vitaly on 22.10.15.
 */
public class CopyBytes {
    public static final String ROOT_PATH = "Ch06_JavaIOFundamentals/src/main/resources/";
    public static void main(String[] args) {
        try (
                InputStream in = new FileInputStream(ROOT_PATH + "xanadu.txt");
                OutputStream out = new FileOutputStream(ROOT_PATH + "outagain.txt")) {

            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
                System.out.print(i + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
