package OCP;

import java.util.Arrays;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        for (Locale locale :Locale.getAvailableLocales()) {
            System.out.printf("%-2s\t%-25s\t%-2s\t%-2s%n", locale.getCountry(), locale.getDisplayCountry(), locale.getLanguage(), locale.getLanguage());
//            final String variant = locale.getScript();
//            if (!variant.isEmpty()) {
//                System.out.println(variant);
//                break;
//            }
        }
    }
}
