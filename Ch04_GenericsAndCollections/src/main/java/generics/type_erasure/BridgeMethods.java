package generics.type_erasure;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vitaly on 10.09.15.
 */
@SuppressWarnings("unchecked")
public class BridgeMethods {
    public static void main(String[] args) {
        MyNode myNode = new MyNode(10);
        Node node = myNode;
        node.setData("hello");
//        myNode.setData(5);
//        new Node<Integer>(5).setData(1);
//        Integer x = myNode.data;
//        Integer y = node.data;
        ///////////////////////////////////2///////////////////////
    }
    public static <T> void addToList (List<T> listArg, T... elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }

    public static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = l[0].get(0);       // ClassCastException thrown here
    }
}

class Test {
    public void foo() {
        throw new RuntimeException();
    }
}

class Node<T> {

    public T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
//        throw new RuntimeException();
    }
}

class MyNode extends Node<Integer> {
    public MyNode(Integer data) { super(data); }

//    @Override
//    public void setData(Integer data) {
//        System.out.println("MyNode.setData");
//        super.setData(data);
//    }
}