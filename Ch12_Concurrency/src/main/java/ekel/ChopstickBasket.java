package ekel;

import java.util.*;

/**
 * Created by vitaly on 25.11.15.
 */
public class ChopstickBasket {
    public static class ChopstickPair extends AbstractMap.SimpleImmutableEntry<Chopstick, Chopstick> {
        public ChopstickPair(Chopstick chopstick1, Chopstick chopstick2) {
            super(chopstick1, chopstick2);
        }
    }

    private final Queue<Chopstick> chopstickQueue;

    public ChopstickBasket() {
        this(Collections.emptySet());
    }

    public ChopstickBasket(Chopstick... chopsticks) {
        this(Arrays.asList(chopsticks));
    }

    public ChopstickBasket(Collection<Chopstick> chopstics) {
        this.chopstickQueue = new LinkedList<>(chopstics);
    }

    public synchronized ChopstickPair takeChopstickPair() throws InterruptedException {
        Chopstick c1 = takeChopstick();
        Chopstick c2 = takeChopstick();

        return new ChopstickPair(c1, c2);
    }

    public synchronized Chopstick takeChopstick() throws InterruptedException {
        while (chopstickQueue.isEmpty()) {
            wait();
        }
        return chopstickQueue.poll();
    }

    public synchronized void putChopstick(Chopstick chopstick) {
        chopstickQueue.offer(chopstick);
        notifyAll();
    }

    public synchronized void putChopstickPair(ChopstickPair chopstickPair) throws InterruptedException {
        putChopstick(chopstickPair.getKey());
        putChopstick(chopstickPair.getValue());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChopstickBasket{")
            .append(chopstickQueue.size())
            .append(" cs. left")
            .append('}');
        return sb.toString();
    }
}
