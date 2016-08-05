package OCP;

import java.io.File;

/**
 * Created by Vitaly on 03.08.2016.
 */
public class FileTest {
    public static void main(String[] args) {
        File f1 = new File("D:\\Java\\OCP\\Ch06_JavaIOFundamentals\\src\\main\\resources\\smith\\data\\zoo.txt");
        File f2 = new File("smith\\data");
        File f3 = new File(f2, "zoo.txt");
        System.out.println("Path.separator: " + File.separator);
        System.out.println("" + f1 + " exists=" + f1.exists());
        System.out.println("" + f2 + " exists=" + f2.exists());
        System.out.println("" + f3 + " exists=" + f3.exists());


    }
}
