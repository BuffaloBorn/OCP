package OCP;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Test {
    public static void bar() {
////    1. Найти три косяка в коде
//        int a = 3 / 2;
//        short s = 6;
//        a = (a / s);
//        foo(5);
//        byte b1 = 2 + 2;
//        byte b2 = b1 + 3;
//
////        2. Что будет выведено на экран?
//        System.out.println("String" == new String("String"));              //
//        System.out.println("String" == "String");                          //
//        System.out.println("String" >= "String");                          //
//        System.out.println(new String("String") == new String("String"));  //
//
//        String string = "012345";
//        string.substring(2);
//        System.out.println(string);                                        //
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


    public static void foo(byte b) {}
}

//Реализовать класс
public class Decision extends Task {
    @Override
    public List<String> stringToWords(String string) {
        int j = 0;
        char[][] word = new char[string.length()][256];

        for (int i=0; i<string.length(); i++){
            if ((string.charAt(i) < 'z'+1) && (string.charAt(i) > 'a'-1) && (string.charAt(i) != '_') && (string.charAt(i) > '1'-1) && (string.charAt(i) != '9'+1)){
                word [j][i] = string.charAt(i);
            } else{
                j++;
                i++;
            }
        }

        return null;
    }

    @Override
    public boolean validateExpression(String string) {
        int k =0;
        int a = 1;
        boolean validity = false;
        for (int i=0; i<string.length(); i++){
            if (string.charAt(i) == '('){
                k++;
            }
            if (string.charAt(i) == ')'){
                k = k-1;
            }
            if (k < 0){
                a = a*0;
            }
        }
        if (k == 0){
            validity = true;
        }
        if (a == 0){
            validity = false;
        }
        return validity;
    }

    public static void main(String[] args) {
        Decision decision = new Decision();
        System.out.print(decision.validateExpression(")("));
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