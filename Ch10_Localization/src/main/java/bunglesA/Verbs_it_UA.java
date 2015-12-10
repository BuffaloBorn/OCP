package bunglesA;

import java.util.ListResourceBundle;

/**
 * Created by vitaly on 10.12.15.
 */
public class Verbs_it_UA extends ListResourceBundle{
    private static final String[][] verbs = {
            {"greeting", "Привет!!!"}
    };

    @Override
    protected Object[][] getContents() {
        return verbs;
    }
}
