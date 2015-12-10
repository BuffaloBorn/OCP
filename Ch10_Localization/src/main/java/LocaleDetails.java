import java.util.Locale;

/**
 * Created by vitaly on 09.12.15.
 */
public class LocaleDetails {
    public static void main(String[] args) {
//        Locale locale = Locale.CANADA_FRENCH;
        Locale locale = new Locale("uk", "UA", "");
        System.out.printf("The default locale is %s %n", locale);
        System.out.printf("The default language code is: %s and the name is: %s %n", locale.getLanguage(), locale.getDisplayLanguage(locale));
        System.out.printf("The default country code is: %s and name is: %s %n", locale.getCountry(), locale.getDisplayCountry(locale));
        System.out.printf("The default variant code is: %s and the name is: %s %n", locale.getVariant(), locale.getDisplayCountry(locale));
    }
}
