package ekel;

import java.util.concurrent.TimeUnit;

/**
 * Created by vitaly on 25.11.15.
 */
public class BasketPhilosopher extends Philosopher {
    private final ChopstickBasket chopstickBasket;

    public BasketPhilosopher(ChopstickBasket chopstickBasket) {
        this.chopstickBasket = chopstickBasket;
    }

    @Override
    protected void takeCutlery() throws InterruptedException {
        ChopstickBasket.ChopstickPair chopstickPair = chopstickBasket.takeChopstickPair();
        System.out.printf("%s taking chopstick pair from basket[%s]...%n", this, chopstickBasket);
        setChopstick1(chopstickPair.getKey());
        setChopstick2(chopstickPair.getValue());

        super.takeCutlery();
    }

    @Override
    public void putCutlery() {
        super.putCutlery();

        System.out.printf("%s putting chopstick pair to the basket[%s]...%n", this, chopstickBasket);
        Chopstick chopstick = null;

        chopstick = getChopstick1();
        setChopstick1(null);
        chopstickBasket.putChopstick(chopstick);

        chopstick = getChopstick2();
        setChopstick2(null);
        chopstickBasket.putChopstick(chopstick);

    }
}
