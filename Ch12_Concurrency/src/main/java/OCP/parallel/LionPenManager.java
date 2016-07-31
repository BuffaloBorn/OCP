package OCP.parallel;

import concurrency.AutoCloseableExecutorService;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * Created by Vitaly on 31.07.2016.
 */
public class LionPenManager {

    public static final int WORKER_COUNT = 4;

    public void removeAnimals() {
        System.out.println("LionPenManager.removeAnimals");
    }

    public void cleanCage() {
        System.out.println("LionPenManager.cleanCage");
    }

    public void addAnimals() {
        System.out.println("LionPenManager.addAnimals");
    }

    public void doJob(CyclicBarrier animalRemoveBabier, CyclicBarrier animalAddingBabier) {
        try {
            removeAnimals();
            animalRemoveBabier.await();
            cleanCage();
//            animalRemoveBabier.reset();
//            animalRemoveBabier.await();
            animalAddingBabier.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try(AutoCloseableExecutorService exec = new AutoCloseableExecutorService(Executors.newFixedThreadPool(WORKER_COUNT))){
            CyclicBarrier animalRemoveBabier = new CyclicBarrier(WORKER_COUNT);
            CyclicBarrier animalAddingBabier = new CyclicBarrier(WORKER_COUNT, () -> System.out.println("Cage cleaned!"));
            for (int i = 0; i < WORKER_COUNT; i++) {
                exec.submit(() ->new LionPenManager().doJob(animalRemoveBabier, animalAddingBabier));
            }
        }
    }
}
