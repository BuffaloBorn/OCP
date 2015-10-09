package collections;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.*;

/**
 * Created by Vitaly on 13.09.2015.
 */
public class QueueTest {
    private static Deque<String> getDeque() {
        final ArrayDeque<String> deque = new ArrayDeque<>(Arrays.asList("ABCDEFG".split("")));
        System.out.println(deque);
        return deque;
    }

    private static void printSectionName(String sectionName) {
        System.out.printf("----------------------------------------------------%s----------------------------------------------------\n", sectionName);
    }

    public static void queueTest() {
        printSectionName("QUEUE");
        Queue<String> queue = getDeque();
        System.out.println("queue.element() = " + queue.element());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.remove() = " + queue.remove());
        System.out.println(queue);
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println(queue);
        System.out.println("queue.offer(\"Z\") = " + queue.offer("Z"));
        System.out.println(queue);
    }

    public static void dequeTest() {
        printSectionName("DEQUE");
        Deque<String> deque = getDeque();
        System.out.println("deque.addFirst(\"0\")");
        deque.addFirst("0");
        System.out.println(deque);
        System.out.println("deque.addLast(\"9\")");
        deque.addLast("9");
        System.out.println(deque);
        System.out.println("deque.removeLast() = " + deque.removeLast());
        System.out.println("deque.removeFirst() = " + deque.removeFirst());
        System.out.println(deque);
        System.out.println("deque.pop() = " + deque.pop());
        System.out.println(deque);
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println(deque);
        System.out.println("deque.push(\"X\")");
        deque.push("X");
        System.out.println(deque);
//        System.out.println("deque.offer(\"Z\") = " + deque.offer("Z"));
    }


    public static void main(String[] args) {
//        Queue<String> loginSequence = new LinkedList<>();
//        loginSequence.add("Harrison");
//        loginSequence.add("McCartney");
//        loginSequence.add("Starr");
//        loginSequence.add("Lennon");
//        System.out.println(loginSequence);
//        while (!loginSequence.isEmpty())
//            System.out.println(loginSequence.remove());
//
//        ArrayDeque<String> deque = new ArrayDeque<>();
//        deque.add("Vitaly");
//        deque.add("Dmitry");
//        deque.add("Alexandr");
        queueTest();
        dequeTest();
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
