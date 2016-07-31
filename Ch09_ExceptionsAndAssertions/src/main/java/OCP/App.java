package OCP;

import trywithresources.AutoCloseableResource;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.zip.DataFormatException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            throw new DateTimeParseException("sdfasd", "000", 0);

        } catch (ClassCastException | IllegalArgumentException | DateTimeParseException e) {
            e.printStackTrace();
//            e = new ClassCastException();
        }

        tryWithRes();
//        tryReg();
    }

    public static void tryWithRes() {
        try (AutoCloseableResource r1 = new AutoCloseableResource();
             AutoCloseableResource r2 = new AutoCloseableResource()) {
            System.out.println("do something...");
//        } catch (RuntimeException e) {
//////            e.printStackTrace();
//            Arrays.toString(e.getSuppressed());
        }
    }
    public static void tryReg() {
        AutoCloseableResource r1 = null;
        AutoCloseableResource r2 = null;
        try  {
            r1 = new AutoCloseableResource();
            r2 = new AutoCloseableResource();
            System.out.println("do something...");
        } catch (RuntimeException e) {
//            e.printStackTrace();
//            Arrays.toString(e.getSuppressed());
        }finally {
            if (r2 != null) r2.close();
            if (r1 != null) r1.close();

        }
    }
}
