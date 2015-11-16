package ekel.excercises;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by vitaly on 11.11.15.
 */
class Counter {
    private int count;
    private Random rnd = new Random(47);

    public int getCount() {
        return count;
    }

    public synchronized int inc(int value) {
        return count += value;
    }

    public synchronized int inc() {
        int temp = count;
        if (rnd.nextBoolean()) {
            try {
                TimeUnit.MILLISECONDS.sleep(rnd.nextInt(500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return count = temp + 1;
//        return count++;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}

abstract class Device {
    protected final Set<Sensor> sensors;

    protected Device(Collection<Sensor> sensors) {
        this.sensors = new CopyOnWriteArraySet<>(sensors);
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
        sensor.setDevice(this);
    }

    public void removeSensor(Sensor sensor) {
        sensors.remove(sensor);
        sensor.setDevice(null);
    }


    public abstract void acceptEvent(Sensor sensor);
}

abstract class Sensor {
    protected Device device;

    public void setDevice(Device device) {
        this.device = device;
    }

    public abstract void alertDevice();
}

class RadioSensor extends Sensor {
    private final Counter counter;

    RadioSensor() {
        this.counter = new Counter();
    }

    @Override
    public void alertDevice() {
        counter.inc();
        device.acceptEvent(this);
    }

    public int getCount() {
        return counter.getCount();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RadioSensor{");
        sb.append("counter=").append(counter);
        sb.append('}');
        return sb.toString();
    }
}

class RadioCounterDevice extends Device {
    private Counter counter = new Counter();
    private Random random = new Random(47);

    public RadioCounterDevice() {
        super(Collections.emptySet());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RadioCounterDevice{");
        sb.append("counter=").append(counter);
        sb.append('}');
        return sb.toString();
    }

    public RadioCounterDevice(Collection<Sensor> sensors) {
        super(sensors);
    }

    @Override
    public synchronized void acceptEvent(Sensor sensor) {
        counter.inc();
    }

    public int summBySensors() {
        int summ = 0;

        for (Sensor sensor : sensors) {
            RadioSensor rs = (RadioSensor) sensor;
            summ += rs.getCount();
            System.out.println(sensor);
        }

        return summ;
    }

    public int getCount() {
        return counter.getCount();
    }

}

class EnvironmentRunner implements Runnable {
    private final Random rnd = new Random();
    private final Sensor sensor;

    EnvironmentRunner(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            sensor.alertDevice();
            try {
                TimeUnit.MILLISECONDS.sleep(rnd.nextInt(500));
            } catch (InterruptedException ignore) {
                return;
            }
        }
    }
}

public class RadioDeviceTest {
    public static void main(String[] args) throws InterruptedException {
        RadioCounterDevice rd = new RadioCounterDevice();
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Sensor sensor = new RadioSensor();
            rd.addSensor(sensor);
            EnvironmentRunner runner = new EnvironmentRunner(sensor);
            exec.execute(runner);
        }
        exec.shutdown();

        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();

        System.out.println(rd.summBySensors());
        System.out.println(rd.getCount());
    }
}
