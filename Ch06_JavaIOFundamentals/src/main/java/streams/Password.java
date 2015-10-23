package streams;

import java.io.Console;
import java.util.Arrays;

/**
 * Created by vitaly on 23.10.15.
 */
public class Password {
    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("No console!!");
            System.exit(1);
        }

        String login = console.readLine("Enter your login: ");
        char[] pwd = console.readPassword("Enter your password: ");

        if (verify(pwd)) {
            boolean noMatch;
            do {
                char[] newPwd1 = console.readPassword("Enter new password: ");
                char[] newPwd2 = console.readPassword("Confirm new password: ");

                noMatch = !Arrays.equals(newPwd1, newPwd2);

                if (noMatch) {
                    console.format("Password do not match. Try again.%n");
                } else {
                    changePassword(newPwd1);
                    console.format("Password for %1$s changed.%n", login);
                }
                Arrays.fill(newPwd1, ' ');
                Arrays.fill(newPwd2, ' ');
            } while (noMatch);
        }
    }

    private static void changePassword(char[] newPwd1) {

    }

    private static boolean verify(char[] pwd) {
        return true;
    }
}
