package try_catch;

import java.util.Arrays;

/**
 * Created by Vitaly on 15.11.2015.
 */
public class TryCatchFinallyTest {
    public static void main(String[] args) {
//        try {
            try {
                throw new RuntimeException();

//            } catch (RuntimeException e) {
//                throw new IllegalArgumentException();
            } finally {
                try {
                    throw new IllegalArgumentException();
                }catch (RuntimeException e) {
                    System.out.println(e);
                }
            }
//        } catch (NullPointerException e) {
//            Arrays.asList(e.getSuppressed()).toString();
//        }
    }
}
