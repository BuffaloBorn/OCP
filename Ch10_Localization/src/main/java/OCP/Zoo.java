package OCP;

import print.PrintUtils;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Vitaly on 09.07.2016.
 */
public class Zoo {
    public static final Locale us = new Locale.Builder().setLanguage("en").setRegion("US").build();
    public static final Locale france = new Locale("fr", "FR");
    public static final Locale canadaFr = new Locale("fr", "CA");
    public static final Locale canadaEn = new Locale("en", "CA");

    public static void main(String[] args) {
//        testBungle();

//        Properties props = new Properties();
//        ResourceBundle bundle = ResourceBundle.getBundle("bungles.Zoo");
//        Set<String> keySet = bundle.keySet();
//        keySet.stream().forEach(k -> props.put(k, bundle.getString(k)));
//        System.out.println(props);

        PrintUtils.printSectionName("Print default key values");
        Locale locale = new Locale("en", "CA");
        ResourceBundle rb = ResourceBundle.getBundle("bungles.Zoo", locale);
        System.out.print(rb.getString("hello"));
        System.out.print(". ");
        System.out.print(rb.getString("name"));
        System.out.print(" ");
        System.out.print(rb.getString("open"));
        System.out.print(" ");
        System.out.print(rb.getString("visitor"));
    }

    public static void testBungle() {
        printProperties(us);
        PrintUtils.printDelimiterString();
        printProperties(france);
    }

    public static void printProperties(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("bungles.Zoo", locale);
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("open"));
        System.out.println(bundle.getString("test"));
//        System.out.println(bundle.getObject("test1"));
    }
}
