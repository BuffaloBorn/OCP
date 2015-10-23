package streams;

import java.io.*;

/**
 * Created by vitaly on 23.10.15.
 */
public class DataStreamTest {

    public static void main(String[] args) {
        String fileName = "invoicedata.dat";
        writeData(fileName);
        readData(fileName);
    }

    private static void readData(String fileName) {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))){
            while (true){
                System.out.printf("%.2f, %d, %s%n", in.readDouble(), in.readInt(), in.readUTF());
            }
        } catch (IOException e) { }

    }

    public static void writeData(String fileName) {
        final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
        final int[] units = { 12, 8, 13, 29, 50 };
        final String[] descs = {
                "Java T-shirt",
                "Java Mug",
                "Duke Juggling Dolls",
                "Java Pin",
                "Java Key Chain"
        };

        try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i < prices.length; i++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
