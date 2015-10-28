package streams;

import OCP.App;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * Created by vitaly on 28.10.15.
 */
public class ShowFile {
    public static void main(String[] args) {
        try {
            InputStream in = Files.newInputStream(App.SUMMARY_PATH);
            int b;

            while ((b = in.read())!=-1)
                System.out.print((char) b);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
