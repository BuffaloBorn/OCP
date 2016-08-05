package OCP;

import java.io.Console;
import java.util.Arrays;

/**
 * Created by Vitaly on 03.08.2016.
 */
public class ConsoleReadInputSample {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console not supported!");
        } else {
            console.format("How excited are you about your trip today? ");
            console.flush();
            String excitedAnswer = console.readLine();
            String login = console.readLine("Enter your login: ");
            char[] rawPwd = console.readPassword("Password");
            String pwd = String.valueOf(rawPwd);
            Arrays.fill(rawPwd, ' ');
            String value = console.readLine("What is your age? ");
            Integer age = null;
            console.writer().append("sdf");
            try {
                age = Integer.valueOf(value);
            } catch (NumberFormatException e) {
                console.writer().println("Incorrect number format");
            }
            console.format("Your name is %s:%s%n", login, pwd);
            console.format("Your age is %s%n", age);
            console.printf("Your excitement level is: " + excitedAnswer);
        }
    }
}
