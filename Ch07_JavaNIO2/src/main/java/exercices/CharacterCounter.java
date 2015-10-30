package exercices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by vitaly on 30.10.15.
 */
public class CharacterCounter {
    public static void main(String[] args) {
        char c = 'e';
        long counter = getCounter(c);
        System.out.println(counter);
    }

    public static long getCounterUrl(char c) {
        long counter = 0;
        int symbol;
        try {
            URL url = new URL("https://docs.oracle.com/javase/tutorial/essential/io/examples/xanadu.txt");
            URLConnection con = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((symbol = reader.read()) != -1) {
                if (symbol == c) {
                    counter++;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    public static long getCounter(char c) {
        long counter = 0;
        int symbol;
        try {
            Path url = Paths.get("/home/vitaly/IdeaProjects/OCP/Ch07_JavaNIO2/src/main/resources/xanadu.txt");
            BufferedReader reader = Files.newBufferedReader(url);
            while ((symbol = reader.read()) != -1) {
                if (symbol == c) {
                    counter++;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
