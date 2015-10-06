package collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.*;

/**
 * Created by Vitaly on 13.09.2015.
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> loginSequence = new LinkedList<>();
        loginSequence.add("Harrison");
        loginSequence.add("McCartney");
        loginSequence.add("Starr");
        loginSequence.add("Lennon");
        System.out.println(loginSequence);
        while (!loginSequence.isEmpty())
            System.out.println(loginSequence.remove());

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("Vitaly");
        deque.add("Dmitry");
        deque.add("Alexandr");
        double p = PI;

//        timer(0, 10);
        System.out.println(-(Integer.MIN_VALUE + 0));
        Object o = 5;
        Integer i = (Integer) o;
    }

    public static void timer(int start, int end) {
        Queue<Integer> timerQueue = new LinkedList<>();
        for (int i = end; i >= start; i--) {
            timerQueue.offer(i);
        }

        Integer value;
        while (!timerQueue.isEmpty()) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) { }

            System.out.println(timerQueue.remove());
        }

    }
}


//At the beginning of this lesson, you learned that the core collection interfaces are organized into two distinct inheritance trees.
// One interface in particular is not considered to be a true Collection, and therefore sits at the top of its own tree. What is the name of this interface? MAP
//Each interface in the collections framework is declared with the <E> syntax, which tells you that it is generic.
// When you declare a Collection instance, what is the advantage of specifying the type of objects that it will contain? GENERICS
//What interface represents a collection that does not allow duplicate elements? SET
//What interface forms the root of the collections hierarchy? COLLECTION
//What interface represents an ordered collection that may contain duplicate elements? LIST
//What interface represents a collection that holds elements prior to processing? QUEUE
//What interface repesents a type that maps keys to values? MAP
//What interface represents a double-ended queue? DEQUE
//Name three different ways to iterate over the elements of a List. STREAM FOR ITERATOR
//True or False: Aggregate operations are mutative operations that modify the underlying collection. FALSE
