package streams;

import java.io.*;

/**
 * Created by vitaly on 22.10.15.
 */
public class CopyCharacters {
    private static final String ROOT_PATH = "Ch06_JavaIOFundamentals/src/main/resources/";

    public static void main(String[] args) {
        try (
                Reader in = new FileReader(ROOT_PATH + "xanadu.txt");
                Writer out = new FileWriter(ROOT_PATH + "characteroutput.txt")) {

            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
