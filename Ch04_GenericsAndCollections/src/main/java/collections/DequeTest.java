package collections;

import java.util.*;

/**
 * Created by Vitaly on 13.09.2015.
 */
public class DequeTest {
    public static void main(String[] args) {
        List<String> loginSequence = new LinkedList<>();
        loginSequence.add("Harrison");
        loginSequence.add("McCartney");
        loginSequence.add("Starr");
        loginSequence.add("Lennon");
        Comparator<String> stringComparator = (o1, o2) -> o1.compareTo(o2);

//        loginSequence.sort(stringComparator);
//        System.out.println(Collections.binarySearch(loginSequence, "Lennon"));
    }
}
