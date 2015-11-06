package ekel.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

/**
 * Created by vitaly on 06.11.15.
 */
public class Fibonacci implements IntFunction<int[]> {
    public static final Fibonacci INSTANCE = new Fibonacci();

    @Override
    public int[] apply(int value) {
        final int[] result = new int[value];
        switch (value) {
            case 0:
                return result;
            case 1: {
                result[0] = 1;
                return result;
            }
            default: {
                result[0] = 1;
                result[1] = 1;
            }
        }

        for (int i = 2; i < value; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }

        return result;
    }

    public static int[] compute(int i) {
        return INSTANCE.apply(i);
    }
}
