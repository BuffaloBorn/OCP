package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//          Аннотация -маркер, которую можно применить к типу данных
@Target(ElementType.TYPE_USE)
@interface TypeAnno {
}

//        Е ще одна аннотация_маркер , которую мо жн о применит ь к типу данных
@Target(ElementType.TYPE_USE)
@interface NotZeroLen {
}

//11 И еще одна аннотация-маркер, которую можно применить к типу данных
@Target(ElementType.TYPE_USE)
@interface Unique {
}

//        Параме тризированная аннотаци я , кот орую можно приме нить к типу данных
@Target(ElementType.TYPE_USE)
@interface MaxLen {
    int value();
}

//        Аннот ация , которую можно применить к параметру типа
@Target(ElementType.TYPE_PARAMETER)
@interface What {
    String description();
}

//        Ан нотаци я , которую можно применить в объявлении поля
@Target(ElementType.FIELD)
@interface EmptyOK {
}

//        Аннотаци я , которую можно применить в объя влении ме тода
@Target(ElementType.METHOD)
@interface Recommended {
}

public class AnnotationsTest<@What(description = "Bla bla") T> {

    public @Unique AnnotationsTest() {
    }

    @TypeAnno String string;

    @EmptyOK
    String test;

    public int foo(@TypeAnno int x) {
        return 10;
    }

    public @TypeAnno Integer foo2(int x, int y) {
        return x + y;
    }


    @Recommended
    public Integer foo3(String s) {
        return s.length();
    }

    public void foo4() throws @TypeAnno RuntimeException {

    }

    String @MaxLen(10) [] @NotZeroLen [] matrix;

    @TypeAnno String[] strings;
}

class SomeClass extends @TypeAnno AnnotationsTest {
    public static void main(String[] args) {
        AnnotationsTest<@TypeAnno Integer> test = new @TypeAnno AnnotationsTest<>();
        byte b = (@TypeAnno byte) 10;
    }
}

