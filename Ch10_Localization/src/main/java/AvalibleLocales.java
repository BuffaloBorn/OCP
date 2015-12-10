import java.util.Locale;

/**
 * Created by vitaly on 09.12.15.
 */
public class AvalibleLocales {
    public static void main(String[] args) {
        System.out.println("The default locale is: " + Locale.getDefault());
        Locale[] locales = Locale.getAvailableLocales();
        System.out.printf("No. of available locales is: %d,  and they are: %n", locales.length);
        for (Locale locale : locales) {
            System.out.printf("Locale code: %-15s\t%-10s %n", locale, locale.getDisplayName());
        }
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
        for (Locale locale : locales) {
            if (!locale.getLanguage().equals("en")) {
                continue;
            }

            System.out.printf("Locale code: %-15s\t%-10s %n", locale, locale.getDisplayName());
        }

    }
}
