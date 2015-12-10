import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vitaly on 09.12.15.
 */
public class LocalizedHello {
    public static void main(String[] args) {
//        Locale currentLocale = Locale.getDefault();
        final Locale.Builder builder = new Locale.Builder().setLanguage("it");
        Locale currentLocale = builder.build();
        ResourceBundle bundle = ResourceBundle.getBundle("bungles.Verbs", currentLocale);
        System.out.println(bundle.getString("greeting"));
    }
}
