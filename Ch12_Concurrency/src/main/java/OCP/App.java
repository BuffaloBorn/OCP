package OCP;

import java.util.function.IntConsumer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        IntWrapper i = new IntWrapper(1);
        IntConsumer c = value -> {
            i.setValue(i.getValue() + 1);;
        };
        System.out.println(i);
        c.accept(0);
        System.out.println(i);

    }
}

class IntWrapper extends Number {
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public IntWrapper(int value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}