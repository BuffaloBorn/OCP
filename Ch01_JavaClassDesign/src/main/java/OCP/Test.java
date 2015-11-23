package OCP;

import sun.misc.Regexp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    static class Homer {
        public final String name = "Homer Simpson";

        public void saySomthing() {
            System.out.println("D'oh!");
        }

        public static void whatsaaaaapp() {
            System.out.println("Homer wasssaaap!");
        }
    }

    static class Bart extends Homer {
        public final String name = "Bart Simpson";

        public void saySomthing() {
            System.out.println("Ay caramba!");
        }

        public static void whatsaaaaapp() {
            System.out.println("Bart wasssaaap!");
        }
    }

    public static void foo(byte b) { }

    public static void main(String... args) {
//    public static void test() {
////        1. Найти три косяка в коде
//        int anInt = 3 / 2;
//        short aShort = 6;
//        long aLong = 6;
//        anInt = anInt + aLong;//
//        foo(5);
//        byte b1 = 2 + 2;
//        byte b2 = b1 + 3;
//
////        2. Что будет выведено на экран?
//        System.out.println("String" == String.valueOf("String"));             //t
//        System.out.println("String" == "String");                             //t
//        System.out.println("String" >= "String");                             //E
//        System.out.println(new String("String") == new String("String"));     //f
//
//        String string = "012345";
//        string.substring(2);
//        System.out.println(string);                                           //
//
////        3. Какой метод вызовется?
//        bar(5);                                                               //
//
//        4. Что выведется на экран?
//        Homer bart = new Bart();                                              //
//        bart.saySomthing();                                                   //
//        bart.whatsaaaaapp();                                                  //
//        System.out.println(bart.name);                                        //
//
////          5. Что выведется на экран?
//        List<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(3);
//        List<? extends Number> numbers = integers;
//        System.out.println(numbers);
//
////          5. Что выведется на экран?
//        try {
//            System.out.println("1");
//            foo();
//            System.out.println("2");
//        } catch (IllegalArgumentException e) {
//            System.out.println("3");
//        } finally {
//            System.out.println("4");
//            foo();
//        }
//        System.out.println("5");
    }

    public static void foo() { throw new IllegalArgumentException();}

    public static void bar(long l) {
        System.out.println("Test.bar(long l)");
    }

    public static void bar(Integer i) {
        System.out.println("Test.bar(Integer i)");
    }

    public static void bar(int... ints) {
        System.out.println("Test.bar(int... ints)");
    }
}

//6. Overriding
class Father {
    List<Number> foo()throws IOException {
        return null;
    }
}

//Какие перегруженые методы верны?
class Son extends Father {
//    @Override LinkedList<Number> foo() throws FileNotFoundException { return null; }
//    @Override ArrayList<Integer> foo() throws IOException { return null; }
//    @Override List<Number> foo(int i) throws Exception { return null; }
//    @Override ArrayList<Number> foo() throws IOException { return null; }
//    @Override List<Number> foo() throws Exception { return null; }
//    @Override Object foo() throws { return null; }
//    @Override List foo() throws RuntimeException, IllegalAccessError, NullPointerException { return null; }


}

