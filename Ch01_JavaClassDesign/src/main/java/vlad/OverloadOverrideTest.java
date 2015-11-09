package vlad;

/**
 * Created by Vitaly on 07.11.2015.
 */
public class OverloadOverrideTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        b.foo(5);
        b.foo();
        b.foo();
        b.foo();
        b.foo(1.7);
        A.prava = "sdf";
        b = null;

    }
}

class A {
    private int i = 1;

    A() { System.out.println("Constructor"); }

    {System.out.println("Hello");}
    static {System.out.println("world");}
    public static String prava = "Prava";
//    public A() {
//        super();
//    }
    public void foo() {
        System.out.println("A.foo()");
        System.out.println(i++);
    }

    public void foo(int i) {
        System.out.println("A.foo(int)");
        System.out.println(this.i++);
    }
}

class B extends A {
    public String foo(double d) {
        System.out.println("B.foo(double)");
        return null;
    }

    @Override
    public void foo() {
        System.out.println("B.foo()");
//        foo();
    }
    @Override
    public void finalize() {

    }
}