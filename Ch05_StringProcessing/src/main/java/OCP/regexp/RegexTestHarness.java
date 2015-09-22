package OCP.regexp;
import java.io.Console;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args) {
//        Console console = System.console();
//        if (console == null) {
//            System.err.println("No console.");
//            System.exit(1);
//        }
        Scanner console = new Scanner(System.in);
        String regexp = null;
        while (true) {
            System.out.print("Enter your regex: ");
            String newRegexp = console.nextLine();
            regexp = newRegexp.isEmpty() ? regexp : newRegexp;
            Pattern pattern = Pattern.compile(regexp);

            System.out.print("Enter input string to search: ");
            Matcher matcher = pattern.matcher(console.nextLine());
//        Pattern pattern = Pattern.compile("foo");
//        Matcher matcher = pattern.matcher("foo");
            boolean found = false;

            while (matcher.find()) {
                System.out.printf("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if (!found) {
                System.out.printf("No match found.%n");
            }
        }
    }
}
