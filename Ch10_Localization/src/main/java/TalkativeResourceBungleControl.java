import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vitaly on 10.12.15.
 */
public class TalkativeResourceBungleControl extends ResourceBundle.Control{
    @Override
    public List<Locale> getCandidateLocales(String baseName, Locale locale) {
        final List<Locale> candidateLocales = super.getCandidateLocales(baseName, locale);
        System.out.printf("Candidate locales for base bundle name %s and locale %s %n", baseName, locale);
        for (Locale l : candidateLocales) {
            System.out.println(l);
        }

        return candidateLocales;

    }
}
