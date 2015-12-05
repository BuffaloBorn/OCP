package join_fork;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by vitaly on 02.12.15.
 */
public class TreeSummCalculator extends RecursiveTask<Integer> {
    private final Node<?> tree;

    public TreeSummCalculator(Node<?> tree) {
        this.tree = tree;
    }

    @Override
    protected Integer compute() {
        int summ = Optional.ofNullable(tree.getValue()).orElse(0).intValue();
        Collection<Node> nodes = tree.getChilNodes();
        Collection<ForkJoinTask<Integer>> tasks = new LinkedList<>();

        for (Node<?> node : tree.getChilNodes()) {
            TreeSummCalculator newTask = new TreeSummCalculator(node);
            newTask.fork();
            tasks.add(newTask);
        }

        for (ForkJoinTask<Integer> task :tasks) {
            summ += task.join();
        }


        System.out.println(this + ": " + summ);
        return summ;
    }

    public static void main(String[] args) {
        IntegerNode tree = new IntegerNode(5);
        tree.addChild(5).addChild(5).addChild(5);
        ForkJoinTask<Integer> mainTask = new TreeSummCalculator(tree);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(mainTask));
        ConcurrentMap<String, List<Integer>> map = new ConcurrentHashMap<>();
        List<Integer> list = map.computeIfAbsent("A", s -> new ArrayList<>(Collections.singletonList(1)));

//        List<Integer> list2 = map.compute("A", (s, integers) -> {if ()return integers;});
    }
}

interface Node<T extends Number> {
    Collection<Node> getChilNodes();

    T getValue();
}

class IntegerNode implements Node<Integer> {
    private final Integer value;
    private final Collection<Node> childs = new LinkedList<>();

    IntegerNode() {
        this(null);
    }

    public IntegerNode(Integer value) {
        this.value = value;
    }

    public IntegerNode addChild(int value) {
        final IntegerNode child = new IntegerNode(value);
        childs.add(child);

        return child;
    }

    @Override
    public Collection<Node> getChilNodes() {
        return childs;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}

