package assertions;

/**
 * Created by vitaly on 13.10.15.
 */
public class AssertionsTest {
    public static void main(String[] args) {
        System.out.println("sdfasdf");
        assert false : "Assert test!!!";
        DisableAssetrions.foo();

    }
}

class DisableAssetrions {
    public static void foo() {
        assert false : "Assert Error!!!!!!";
        System.out.println("DisableAssetrions.foo");
    }
}