package OCP;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaly on 03.08.2016.
 */
public class CopyTextFileSample {
    public static void main(String[] args) throws IOException {
        String src = "D:\\Java\\OCP\\Ch06_JavaIOFundamentals\\src\\main\\java\\OCP\\App.java";
        String dst = "D:\\Java\\OCP\\Ch06_JavaIOFundamentals\\src\\main\\java\\OCP\\App.txt";
        List<String> data = readFromFile(src);
        writeToFile(dst, data);

    }

    private static void writeToFile(String filePath, List<String> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String s :data) {
                System.out.println(s);
                writer.write(s);
                writer.newLine();
            }

        }
    }

    private static List<String> readFromFile(String filePath) throws IOException {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String s;
            while ((s = reader.readLine()) != null) {
                data.add(s);
            }
        }
        return data;
    }


}
