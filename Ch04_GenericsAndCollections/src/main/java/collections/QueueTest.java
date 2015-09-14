package collections;

import java.util.LinkedList;
import java.util.Queue;

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
    }
}
