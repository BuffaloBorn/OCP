package ekel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by vitaly on 26.11.15.
 */
public class Pool<T> {
    private List<T> objects;
    private boolean[] checkOut;
    private Semaphore semaphore;

    public Pool(Class<T> clazzObject, int size) {
        createObjects(clazzObject, size);
    }

    private void createObjects(Class<T> clazzObject, int size) {
        objects = new ArrayList<>(size);
        checkOut = new boolean[size];
        semaphore = new Semaphore(size);

        for (int i = 0; i < size; i++) {
            try {
                T instance = clazzObject.newInstance();
                objects.add(instance);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public T checkOut() throws InterruptedException {
        semaphore.acquire();
        return getObject();
    }

    private synchronized T getObject(){
        for (int i = 0; i < checkOut.length; i++) {
            if (!checkOut[i]) {
                checkOut[i] = true;
                return objects.get(i);
            }
        }

        return null;
    }

    public boolean checkIn(T object) {
        final boolean relized = putObject(object);
        if (relized) {
            semaphore.release();
        }

        return relized;
    }

    private synchronized boolean putObject(T object) {
        int index = objects.indexOf(object);
        if (index != -1 && checkOut[index]) {
            checkOut[index] = false;
            return true;
        }
        return false;
    }
}
