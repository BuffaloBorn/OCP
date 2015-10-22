package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by vitaly on 22.10.15.
 */
public class ScanXan {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(CopyBytes.ROOT_PATH + "xanadu.txt")))) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
