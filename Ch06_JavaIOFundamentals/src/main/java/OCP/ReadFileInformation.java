package OCP;

import sun.security.jca.GetInstance;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;

/**
 * Created by Vitaly on 03.08.2016.
 */
public class ReadFileInformation {
    public static void main(String[] args) {
        File file = new File("D:\\Java\\OCP\\");
//        File file = new File("D:\\Java\\OCP\\Ch06_JavaIOFundamentals\\src\\main\\resources\\smith\\data\\zoo.txt");
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.println("File exists: " + file.exists());
        if (file.exists()) {
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Parent path: " + file.getParent());
            if (file.isFile()) {
                System.out.println("File size: " + file.length());
                System.out.println("Last modified: " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.of("Europe/Kiev")));
            } else {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File subfile : files) {
                        System.out.println("\t" + subfile.getName());
                    }
                }
            }
        }
    }
}
