package OCP;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vitaly on 08.10.15.
 */
public class Exercises {
    public static void foo(byte b) {
    }

    //    2. разбить строку на слова
    public static List<String> stringToWords(String string) {
        List<String> list = new ArrayList<>();
        int j = 0;
        boolean flag = false;
        for (int i = 0; i < string.length(); i++) {
            char charAt = string.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z') || charAt == '_' || (charAt >= '0' && charAt <= '9' )) {
                if (flag == false) {
                    flag = true;
                    j = i;
                }
            } else if (flag) {
                list.add(string.substring(j, i));
                flag = false;
            }
            if (i == string.length() - 1 && flag) {
                list.add(string.substring(j, ++i));
            }
        }

//        for (String substr : list ) {
//            if(substr.equals(" ") && substr.charAt())
//        }

//        String[] strarr = string.split(" \\*[a-zA-Z]\\+");
//        for (int i = 0; i < strarr.length; i++) {
//            list.add(strarr[i]);
//        }
        return list;
    }


    //    3. Проверить правильность скобок в выражении
    public static boolean validateExpression(String string) {
        int i = 0;
        char[] cars = string.toCharArray();
        for (char c : cars) {
            if (c == '(') {
                i++;
            }else if (c == ')') {
                i--;
            }
            if (i < 0) {
                return false;
            }
        }

        return i == 0;

//        Stack stack = new Stack();
//        for (int i = 0; i < string.length(); i++) {
//            if(string.charAt(i) == '(' || ch)
//        }
//        int countOpen = 0;
//        int countClose = 0;
//        for (int i = 0; i < string.length(); i++) {
//            if (string.charAt(i) == '(') {
//                countOpen++;
//            }
//            if (string.charAt(i) == ')') {
//                countClose++;
//            }
//        }
//        if (countOpen == countClose) {
//            return true;
//        }
//        return false;
    }

    public static void main(String[] args) {

//    1. Найти три косяка в коде
//        int a = 3 / 2;
//        short l = 6;
//        a = (a / l);
//        foo(5);
//        byte b1 = 2 + 2;
//        byte b2 = b1 + 3;

//        2. Что будет выведено на экран?
//        System.out.println("String" == new String("String"));               //
//        System.out.println("String" == "String");                           //
//        System.out.println("String" >= "Stringu");                          //
//        System.out.println(new String("String") == new String("String"));   //
//
//        String s = "012345";
//        s.substring(2);
//        System.out.println(s);                                              //

//        String string = "asdf as;dfas df as f  g dfh r j     jf gj f  ff;fg;j;;df  gfghj,rt";
//        List list = stringToWords(string);
//        System.out.println(list);
//        System.out.println(list.size());
        int i = 10;
        assert false : "Blya!!!";
        assert true : "Blya!!!";
        System.out.println(validateExpression(")("));

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