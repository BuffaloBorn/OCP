package collections;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by vitaly on 07.10.15.
 */
public class SetTest {
    private static TreeSet<String> getTreeSet() {

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(Arrays.asList("f d s l l u n d y a e i o w l g h".split(" +")));
        System.out.println(treeSet);

        return treeSet;
    }

    private static void printSectionName(String sectionName) {
        System.out.printf("----------------------------------------------------%s----------------------------------------------------\n", sectionName);
    }

    public static void sortedSetTest() {
        printSectionName("SORTED SET");
        SortedSet<String> sortedSet = getTreeSet();
        System.out.println("sortedSet.first() = " + sortedSet.first());
        System.out.println("sortedSet.last() = " + sortedSet.last());
        System.out.println("sortedSet.subSet(\"f\", \"h\") = " + sortedSet.subSet("f", "h"));
        System.out.println("sortedSet.tailSet(\"h\") = " + sortedSet.tailSet("h"));
        System.out.println("sortedSet.headSet(\"h\") = " + sortedSet.headSet("h"));
    }

    public static void navigatableSetTest() {
        printSectionName("NAVIGATABLE SET");
        NavigableSet<String> navigableSet = getTreeSet();
        System.out.println("navigableSet.lower(\"d\") = " + navigableSet.lower("d"));
        System.out.println("navigableSet.lower(\"a\") = " + navigableSet.lower("a"));
        System.out.println("navigableSet.floor(\"d\") = " + navigableSet.floor("d"));
        System.out.println("navigableSet.floor(\"a\") = " + navigableSet.floor("a"));
        System.out.println("navigableSet.higher(\"d\") = " + navigableSet.higher("d"));
        System.out.println("navigableSet.ceiling(\"d\") = " + navigableSet.ceiling("d"));
        System.out.println("navigableSet.pollFirst() = " + navigableSet.pollFirst());
        System.out.println("navigableSet.pollLast() = " + navigableSet.pollLast());
        System.out.println(navigableSet);
    }
    public static void main(String[] args) {
        sortedSetTest();
        navigatableSetTest();
    }
}
