package ekel.excercises;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by vitaly on 13.11.15.
 */
public class OrnamentGarden {
    private final Counter counter = new Counter();
    private final CopyOnWriteArraySet<Wicket> wickets = new CopyOnWriteArraySet<>();

    public void addWicket(Wicket wicket) {
        wickets.add(wicket);
    }

    public synchronized void enter() {
        counter.inc();
    }
}

class Wicket implements Runnable {
    private static int idCounter = 0;
    private final Counter counter = new Counter();
    private final OrnamentGarden ornamentGarden;

    Wicket(OrnamentGarden ornamentGarden) {
        this.ornamentGarden = ornamentGarden;
        ornamentGarden.addWicket(this);
    }

    public void enter() {
        counter.inc();
        ornamentGarden.enter();
        System.out.printf("Wicket: %d entrance: %d TOTAL: %d%n");
    }

    @Override
    public void run() {

    }
}