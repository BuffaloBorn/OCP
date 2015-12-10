import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vitaly on 10.12.15.
 */
public class CandidateLocales {
    public static void main(String[] args) {
        final String baseName = "bunglesA.Verbs";
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.UK, new TalkativeResourceBungleControl());
        String rbLocaleName = bundle.getLocale().toString();

        if (rbLocaleName.equals("")) {
            System.out.println("Loaded the default bungle with name: " + baseName);
        } else {
            System.out.println("Loaded resource bundle for the locale: " + baseName + "." + rbLocaleName);
        }

//        System.out.println(bundle.getString("greeting"));
    }
}
