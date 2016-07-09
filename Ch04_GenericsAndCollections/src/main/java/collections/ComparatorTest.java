package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vitaly on 13.09.2015.
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<KeyContainer> list = new ArrayList<>();
        list.add(new KeyContainer(1, 3, 2));
        list.add(new KeyContainer(1, 2, 2));
        list.add(new KeyContainer(2, 4, 1));
        list.add(new KeyContainer(0, 3, 1));
        System.out.println(list);
        Comparator<KeyContainer> comparator = (o1, o2) -> Integer.compare(o1.getA(), o2.getA());
        list.sort(comparator.thenComparingInt(KeyContainer::getB));
        System.out.println(list);
        list.stream().sorted().count();
    }
}

class KeyContainer {
    private final int a, b, c;

    KeyContainer(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("(")
                .append(a)
                .append(", ").append(b)
                .append(", ").append(c)
                .append(')');

        return sb.toString();
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}

class Squirrel {
    private String species;

    private int weight;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

//Using static methods of Comparator & method chaining
class ChainingComparator implements Comparator<Squirrel> {
    @Override
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(Squirrel::getSpecies).thenComparing(Squirrel::getWeight);
        return compare(s1, s2);
    }
}