package bunglesA;

import java.util.ListResourceBundle;

/**
 * Created by vitaly on 10.12.15.
 */
public class Verbs_it extends ListResourceBundle{
    private static final String[][] verbs = {
            {"greeting", "Италия!!!"}
    };

    @Override
    protected Object[][] getContents() {
        return verbs;
    }
}
