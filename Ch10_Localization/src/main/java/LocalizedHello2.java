import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vitaly on 09.12.15.
 */
public class LocalizedHello2 {
    public static void main(String[] args) {

//        Locale currentLocale = Locale.getDefault();
        Locale.Builder builder = new Locale.Builder().setLanguage("it").setRegion("UR");
        Locale currentLocale = builder.build();
        ResourceBundle bundle = ResourceBundle.getBundle("bunglesA.Verbs", currentLocale);
        System.out.println(bundle.getString("greeting"));
    }
}
