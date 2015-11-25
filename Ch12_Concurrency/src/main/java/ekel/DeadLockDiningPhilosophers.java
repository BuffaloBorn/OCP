package ekel;

import ekel.generators.SerialNumberGenerator;
import ekel.utils.IntGenerator;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vitaly on 25.11.15.
 */
public class DeadLockDiningPhilosophers {
    public static void main(String[] args) {
        final int amount = 5;
        IntGenerator idGenerator = new SerialNumberGenerator();
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[5];

        Arrays.setAll(chopsticks, value -> new Chopstick(idGenerator.next()));

        test2(amount, exec, chopsticks);

    }

    public static void test(int amount, ExecutorService exec, Chopstick[] chopsticks) {
        for (int i = 0; i < amount; i++) {
            Chopstick firstStick = chopsticks[i % amount];
            Chopstick secondStick = chopsticks[(i + 1) % amount];
            exec.execute(new Philosopher(firstStick, secondStick));
        }
    }

    public static void test1(int amount, ExecutorService exec, Chopstick[] chopsticks) {
        for (int i = 0; i < amount - 1; i++) {
            Chopstick firstStick = chopsticks[i % amount];
            Chopstick secondStick = chopsticks[(i + 1) % amount];
            exec.execute(new Philosopher(firstStick, secondStick));
        }
        Chopstick firstStick = chopsticks[0];
        Chopstick secondStick = chopsticks[amount - 1];
        exec.execute(new Philosopher(firstStick, secondStick));
    }

    private static void test2(int amount, ExecutorService exec, Chopstick[] chopsticks) {
        ChopstickBasket chopstickBasket = new ChopstickBasket(chopsticks);

        for (int i = 0; i < amount; i++) {
            exec.execute(new BasketPhilosopher(chopstickBasket));
        }
    }
}
