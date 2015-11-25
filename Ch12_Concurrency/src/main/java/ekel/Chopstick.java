package ekel;

/**
 * Created by vitaly on 25.11.15.
 */
public class Chopstick {
    private final int id;
    private boolean taken;

    public Chopstick(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }

        taken = true;
    }

    public synchronized void put() {
        taken = false;
        notifyAll();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chopstick chopstick = (Chopstick) o;

        return id == chopstick.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chopstick{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
