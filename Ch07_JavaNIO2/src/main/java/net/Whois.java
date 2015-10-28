package net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by vitaly on 28.10.15.
 */
public class Whois {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);) {
            String address;
            do {
                address = scanner.nextLine() + '\n';
                try (
                        Socket socket = new Socket("whois.internic.net", 43);
                ) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    OutputStream out = socket.getOutputStream();

                    byte[] outBuf = address.getBytes();
                    out.write(outBuf);

                    String str;
                    while ((str = reader.readLine()) != null)
                        System.out.println(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (!address.equalsIgnoreCase("exit"));
        }
    }
//    public static void main(String[] args) throws Exception {
//        Socket s = new Socket("whois.internic.net", 43);
//
//        OutputStream os = s.getOutputStream();
//        String domain = "facebook.com";
//        byte[] stringToByte = domain.getBytes();
//        os.write(stringToByte);
//
//        InputStream is = s.getInputStream();
//        InputStreamReader reader = new InputStreamReader(is);
//        BufferedReader buf = new BufferedReader(reader);
//
//        String temp;
//        while ((temp = buf.readLine()) != null) {
//            System.out.println(temp);
//        }
//    }
}
