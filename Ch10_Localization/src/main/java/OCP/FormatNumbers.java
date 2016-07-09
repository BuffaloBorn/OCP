package OCP;

import print.PrintUtils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Vitaly on 09.07.2016.
 */
public class FormatNumbers {
    public static int visitorsPerYear = 3_200_000;
    public static double visitorsPerMonth = visitorsPerYear / 12;
    public static double price = 48;
    private final Locale locale;
    private final NumberFormat format;

    public FormatNumbers(Locale locale) {
        this.locale = locale;
        format = NumberFormat.getInstance(locale);
    }

    public void printVisitorsStatistics() {
        System.out.println("Visitors per year: " + format.format(visitorsPerYear));
        System.out.println("Visitors per month: " + format.format(visitorsPerMonth));
        System.out.println("price: " + NumberFormat.getCurrencyInstance(locale).format(price));
    }

    public static void main(String[] args) {
        FormatNumbers us = new FormatNumbers(Locale.US);
        FormatNumbers g = new FormatNumbers(Locale.GERMANY);
        FormatNumbers ca = new FormatNumbers(Locale.CANADA_FRENCH);
        PrintUtils.printSectionName("USA");
        us.printVisitorsStatistics();
        PrintUtils.printSectionName("Germany");
        g.printVisitorsStatistics();
        PrintUtils.printSectionName("Canada france");
        ca.printVisitorsStatistics();
    }
}
