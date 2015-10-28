package net;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by vitaly on 28.10.15.
 */
public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL fakePersons = new URL("https://fejk.se");

        System.out.println("Протокол: " + fakePersons.getProtocol());
        System.out.println("порт: " + fakePersons.getPort());
        System.out.println("Хост: " + fakePersons.getHost());
        System.out.println("Файл: " + fakePersons.getFile());
        System.out.println("Полная форма: " + fakePersons.toExternalForm());

    }
}
