package OCP;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Vitaly on 09.07.2016.
 */
public class Tax_en_US extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"tax", 20.0},};
    }

    public static void main(String[] args) {
        ResourceBundle bundle = getBundle("OCP.Tax", Locale.FRANCE);
        Object tax = bundle.getObject("tax");
        System.out.println(tax);
        System.out.println(Locale.getDefault());
    }
}

