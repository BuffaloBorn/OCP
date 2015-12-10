package bunglesA;

import java.util.ListResourceBundle;

/**
 * Created by vitaly on 10.12.15.
 */
public class Verbs extends ListResourceBundle{
    private static final String[][] verbs = {
            {"greeting", "Hello!!!"}
    };

    @Override
    protected Object[][] getContents() {
        return verbs;
    }
}
