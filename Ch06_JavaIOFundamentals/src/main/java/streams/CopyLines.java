package streams;

import java.io.*;

/**
 * Created by vitaly on 22.10.15.
 */
public class CopyLines {
    private static final String ROOT_PATH = "Ch06_JavaIOFundamentals/src/main/resources/";

    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(new FileReader(ROOT_PATH + "xanadu.txt"));
                PrintWriter out = new PrintWriter(new FileWriter(ROOT_PATH + "lineoutput.txt"))) {
            String s;
            while ((s = in.readLine()) != null){
                out.println(s);
                System.out.print(s);
            }
                } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
