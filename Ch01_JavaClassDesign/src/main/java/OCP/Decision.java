package OCP;

import sun.misc.Regexp;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Test {
    static class Homer {
        public final String name = "Homer Simpson";

        public void saySomthing() {
            System.out.println("D'oh!");
        }

        public static void wasssaaap() {
            System.out.println("Homer wasssaaap!");
        }

    }

    static class Bart extends Homer {
        public final String name = "Bart Simpson";

        public void saySomthing() {
            System.out.println("Ay caramba!");
        }

        public static void wasssaaap() {
            System.out.println("Bart wasssaaap!");
        }
    }

    public static void main(String... args) {
//    public static void test() {
////        1. Найти три косяка в коде
//        int anInt = 3 / 2;
//        short aShort = 6;
//        long aLong = 6;
//        anInt = anInt + aLong;
//        foo(5);
//        byte b1 = 2 + 2;
//        byte b2 = b1 + 3;
//
////        2. Что будет выведено на экран?
//        System.out.println("String" == String.valueOf("String"));             //
//        System.out.println("String" == "String");                             //
//        System.out.println("String" >= "String");                             //
//        System.out.println(new String("String") == new String("String"));     //
//
//        String string = "012345";
//        string.substring(2);
//        System.out.println(string);                                           //
//
////        3. Какой метод вызовется?
//        bar(5);                                                               //
//
////        4. Что выведется на экран?
//        Homer bart = new Bart();                                              //
//        bart.saySomthing();                                                   //
//        bart.wasssaaap();                                                     //
//        System.out.println(bart.name);                                        //
//
////          5. Что выведется на экран?
//        List<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(3);
//        List<Number> numbers = integers;
//        System.out.println(numbers);
    }

    public static void foo(byte b) {
    }

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


abstract class Task {
    //    2. разбить строку на слова
//    Словом считается последовательность символов произвольной длинны состоящая из:
//        1. символов латинского алфавита
//        2. цифр
//        3. знака подчеркивания
//    все остальные символи считаются разделителями
    public abstract List<String> stringToWords(String string);

    //    3. Проверить правильность скобок в выражении
//    каждая открывающая скобка "(" должна иметь соответствующую закрывающую скобку ")"
//    между скобками может находится любая последовательность символов, либо вложенных скобок.
//    пример: x = f * (n - 1 / 3 + sqrt(8)) + (y * x - 5 * (y * (n - 4)))
    public abstract boolean validateExpression(String string);

}

//Реализовать класс
public class Decision extends Task {
    @Override
    public List<String> stringToWords(String string) {
        return null;
    }

    @Override
    public boolean validateExpression(String string) {
        return false;
    }

}

abstract class Father {

    //Определение абстрактного метода
    //Перегрузка (Имя метода одинаковое, а типы или количество входящих параметров разное. На возвращаемое значение похуй.)
    public abstract Number foo(int i);

    //Перегрузка
    public int foo(int x, int y) {
        System.out.println("Father.foo(int, int)");
        return x;
    }

    //Перегрузка
    public void foo() {
        System.out.println("Father.foo()");
    }
}

class Son extends Father {

    //Реализация абстрактного метода родителя(для этого необходимо совпадение сигнатур методов(имя и количество и типы входящих параметров)
    // + ковариантные(такой же тип или один из его потомков, в данном примепе Integer это потомок Number, но можно было бы использоавать просто Number) типы возвращаемых значений)
    // По другому это можно назвать перегрузкой абстрактного метода
    @Override
    public Integer foo(int i) {
        System.out.println("Son.foo(int)");
        return null;
    }

    //Это просто перегрузка, правила такие же как в примере выше.
    @Override
    public void foo() {
        super.foo();
    }

    //Перегрузка
    public double foo(double d) {
        System.out.println("Son.foo(double)");
        return 0;
    }


}