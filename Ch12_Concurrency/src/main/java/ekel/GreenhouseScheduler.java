package ekel;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static ekel.GreenhouseScheduler.ThermostatState.*;
import static java.time.Duration.*;
import static java.util.concurrent.TimeUnit.*;

/**
 * Created by vitaly on 26.11.15.
 */
public class GreenhouseScheduler {
    private volatile boolean lightOn;
    private volatile boolean waterOn;
    private ThermostatState thermostat = DAY;
    private ScheduledExecutorService exec = Executors.newScheduledThreadPool(10);

    public enum ThermostatState {DAY, NIGHT}

    public synchronized ThermostatState getThermostat() {
        return thermostat;
    }


    public synchronized void setThermostat(ThermostatState thermostat) {
        this.thermostat = thermostat;
    }

    public void schedule(Runnable task, Duration duration) {
        exec.schedule(task, duration.toNanos(), NANOSECONDS);
    }

    public void repeat(Runnable task, Duration initDelay, Duration delay) {
        exec.scheduleAtFixedRate(task, initDelay.toNanos(), delay.toNanos(), NANOSECONDS);
    }

    public static void main(String[] args) {
        GreenhouseScheduler greenhouse = new GreenhouseScheduler();

        Runnable lightOn = () -> {
            System.out.println("Turning on lights");
            greenhouse.lightOn = true;
        };

        Runnable lightOff = () -> {
            System.out.println("Turning off lights");
            greenhouse.lightOn = false;
        };

        Runnable waterOn = () -> {
            System.out.println("Turning on water");
            greenhouse.waterOn = true;
        };

        Runnable waterOff = () -> {
            System.out.println("Turning off water");
            greenhouse.waterOn = false;
        };

        Runnable thermostatDay = () -> {
            System.out.println("Thermostat to day setting");
            greenhouse.waterOn = false;
        };

        Runnable thermostatNight = () -> {
            System.out.println("Thermostat to night setting");
            greenhouse.waterOn = false;
        };

        Runnable bell = () -> {
            System.out.println("Bing!");
        };

        Runnable terminate = () -> {
            System.out.println("Terminating!");
            greenhouse.exec.shutdownNow();
        };

        greenhouse.schedule(terminate, ofSeconds(5));
        greenhouse.repeat(bell, ZERO, ofSeconds(1));
        greenhouse.repeat(thermostatNight, ZERO, ofSeconds(2));
        greenhouse.repeat(lightOn, ZERO, ofMillis(200));
        greenhouse.repeat(lightOff, ZERO, ofMillis(400));
        greenhouse.repeat(waterOn, ZERO, ofMillis(200));
        greenhouse.repeat(waterOff, ZERO, ofMillis(400));
        greenhouse.repeat(thermostatDay, ZERO, ofMillis(1400));
//        greenhouse.repeat(, ZERO, ofMillis());

    }
}
