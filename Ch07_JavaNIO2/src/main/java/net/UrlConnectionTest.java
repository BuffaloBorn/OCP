package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by vitaly on 28.10.15.
 */
public class UrlConnectionTest {
    public static void main(String[] args) throws Exception{
        int c;
        long value;
        URL hp = new URL("http://www.internic.net");
        URLConnection con = hp.openConnection();

        value = con.getDate();
        if (value == -1) {
            System.out.printf("Сведенья о дате отсутствуют%n");
        } else {
            System.out.printf("Дата: %s%n", LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault()));
        }

        System.out.printf("Тип содержимого: %s%n", con.getContentType());

        value = con.getExpiration();
        if (value == -1) {
            System.out.printf("Сведенья о сроке действия отсутствуют%n");
        } else {
            System.out.printf("Срок действия: %s%n", LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault()));
        }

        value = con.getLastModified();
        if (value == -1) {
            System.out.printf("Сведенья о последней дате модификации отсутсвуют.%n");
        } else {
            System.out.printf("Дата поледней модификации: %s%n", LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault()));
        }

        value = con.getContentLengthLong();
        if (value == -1) {
            System.out.printf("Длинна содержимого недоступна%n");
        } else {
            System.out.printf("Длинна содержимого: %s%n", value);
            if (value != 0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String s;
                while ((s = reader.readLine()) != null) {
                    System.out.println(s);
                }
            }
        }
    }


}
