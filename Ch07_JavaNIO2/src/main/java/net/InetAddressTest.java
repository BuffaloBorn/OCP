package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by vitaly on 28.10.15.
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        printHost("www.amazon.com");
        printHost("www.i.ua");
        printHost("www.alfa-holding.net");

    }

    public static void printHost(String hostName) throws UnknownHostException {
        InetAddress[] amazon = InetAddress.getAllByName(hostName);
        System.out.println(amazon[0].getHostName());

        for (InetAddress address :amazon) {
            System.out.printf("\tip: %s%n", address.getHostAddress());
        }
    }
}
