package net;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by vitaly on 28.10.15.
 */
public class HttpUrlTest {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://www.fakenamegenerator.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        System.out.println(con.getRequestMethod());
        System.out.println(con.getResponseCode());
        System.out.println(con.getResponseMessage());
        System.out.println(con.getResponseMessage());
        Map<String, List<String>> headers = con.getHeaderFields();
        headers.forEach((s, stringList) -> System.out.printf("%-50s: %s%n", s, stringList));

//        System.out.println(con.get());
    }
}
