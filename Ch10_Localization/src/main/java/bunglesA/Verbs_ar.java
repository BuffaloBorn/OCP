package bunglesA;

import java.util.ListResourceBundle;

/**
 * Created by vitaly on 10.12.15.
 */
public class Verbs_ar extends ListResourceBundle{
    private static final String[][] verbs = {
            {"greeting", "As-Salamu Alaykum!!!"}
    };

    @Override
    protected Object[][] getContents() {
        return verbs;
    }
}
