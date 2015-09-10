package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by vitaly on 09.09.15.
 */
public class GenericsInheritanceSubtypes {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(10); //OK
        numbers.add(2.8); //OK
//        numbers.add("sdf") //FAIL
        ArrayList<Integer> integers = new ArrayList<>();
//        ArrayList<Number> numbers1 = (ArrayList<Number>)integers; //FAIL
        ArrayList<Number> numbers1 = (ArrayList<Number>)((ArrayList)integers); //TRICK
        numbers1.add(3.5); //Бля, это подстава!!!!!


        Collection<Integer> collection = integers;
        List<Integer> list = integers;
        Iterable iterable = integers; //TRICK Лучще так не делать, а то компилятор будет бурчать предупреждениями
//        List<Number> list1 = integers; //FAIL

        List<String> p1 = new PayloadArrayList<String, Integer>();
        List<String> p2 = new PayloadArrayList<String, String>();
        List<String> p3 = new PayloadArrayList<String, GenericsInheritanceSubtypes>();
//        List<String> p4 = new PayloadArrayList<Integer, String>(); //FAIL
    }
}

interface PayloadList<E,P> extends List<E> {
    void setPayload(int index, P val);
}

class PayloadArrayList<E, P> extends ArrayList<E> {
}