package generics;

import generics.wildcards.Box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by vitaly on 09.09.15.
 */
public class TypeInference {
    static <T> T pick(T a1, T a2) { return a2; }

    public static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" + Objects.toString(boxContents) + "]");
            counter++;
        }
    }

    public static void main(String[] args) {

        ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
        TypeInference.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        TypeInference.addBox(Integer.valueOf(20), listOfIntegerBoxes);
//        TypeInference.addBox(Integer.valueOf(30), new ArrayList<Box<Double>>()); //FAIL тип первого аргумента и Тип параметра листа не совпадают и
        TypeInference.addBox(Integer.valueOf(30), new ArrayList<Box<Integer>>()); //OK
        TypeInference.addBox(Integer.valueOf(30), new ArrayList<Box<Integer>>()); //OK
//        TypeInference.addBox(Integer.valueOf(30), new ArrayList<Box<String>>()); //Fail ???????
        TypeInference.outputBoxes(listOfIntegerBoxes);
        Number result = pick(10, 2.4);
//        Box<Number> numberBox = new Box<Integer>();       //Fail
//        List<Integer> integers = new ArrayList<Number>(); //Fail
//        List<Number> integers1 = new ArrayList<Integer>();//Fail

        //Constructor type parameter
        MyClass<Integer> myClass = new MyClass<Integer>("Hello");
        MyClass<Integer> myClass3 = new MyClass<Integer>(new A());
        List<String> emptyStrings = Collections.emptyList();
        List<String> emptyStrings2 = Collections.EMPTY_LIST; //WARNINGS!!!!
        processStringList(Collections.emptyList()); //Это работает только в java 8 в java 7 нужно явно задавать параметры

    }

    public static void processStringList(List<String> stringList) {
        // process stringList
    }
}

class MyClass<X> {
    public X x;
    <T> MyClass(T t) {
        // ...
    }
}