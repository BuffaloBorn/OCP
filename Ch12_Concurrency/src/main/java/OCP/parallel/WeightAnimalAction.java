package OCP.parallel;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * Created by Vitaly on 31.07.2016.
 */
public class WeightAnimalAction extends RecursiveAction {
    private static final int DEFAULT_LIMIT = 3;
    private static final Random rnd = new Random();

    private final int[] weights;
    private final int start;
    private final int end;
    private int limit;

    public WeightAnimalAction(int[] weights, int start, int end, int limit) {
        this.weights = weights;
        this.start = start;
        this.end = end;
        this.limit = limit;
        System.out.printf("Creating new action start=%2d end=%2d%n", start, end);
    }

    public WeightAnimalAction(int[] weights, int start, int end) {
        this(weights, start, end, DEFAULT_LIMIT);
    }

    @Override
    protected void compute() {
        if (end - start <= limit) {
            for (int i = start; i < end; i++) {
                int weight = rnd.nextInt(10);
                weights[i] = weight;
                System.out.printf("Animal #%2d weight is %3d%n", i, weight);
            }
        } else {
            int middle = start + (end - start) / 2;
            invokeAll(new WeightAnimalAction(weights, start, middle, limit),
                        new WeightAnimalAction(weights, middle, end, limit));
        }
    }

    public static void main(String[] args) {
        int[] weights = new int[15];
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<?> action = new WeightAnimalAction(weights, 0, weights.length);
        ForkJoinTask<Integer> task = new WeightAnimalTask(weights, 0, weights.length);
        pool.invoke(action);
        System.out.println(Arrays.toString(weights));
        Integer sum = pool.invoke(task);
        System.out.printf("Weight sum is: %4d%n", sum);
        System.out.println(IntStream.of(weights).sum());

    }
}

class WeightAnimalTask extends RecursiveTask<Integer> {
    private static final int DEFAULT_LIMIT = 3;
    private static final Random rnd = new Random();

    private final int[] weights;
    private final int start;
    private final int end;
    private int limit;

    public WeightAnimalTask(int[] weights, int start, int end, int limit) {
        this.weights = weights;
        this.start = start;
        this.end = end;
        this.limit = limit;
        System.out.printf("Creating new task start=%2d end=%2d%n", start, end);
    }

    public WeightAnimalTask(int[] weights, int start, int end) {
        this(weights, start, end, DEFAULT_LIMIT);
    }

    @Override
    protected Integer compute() {
        if (end - start <= limit) {
            int weight = 0;
            for (int i = start; i < end; i++) {
                weight += weights[i];
            }
            System.out.printf("Calculated weight is %4d%n", weight);
            return weight;
        } else {
            int middle = start + (end - start) / 2;
            WeightAnimalTask task = new WeightAnimalTask(weights, start, middle, limit);
            task.fork();
            return new WeightAnimalTask(weights, middle, end, limit).compute() + task.join();
        }
    }
}