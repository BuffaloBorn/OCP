package patterns.observer;

import javafx.beans.InvalidationListener;
import java.util.Observable;

import java.util.LinkedList;
import java.util.List;
import java.util.Observer;
import java.util.function.Predicate;

/**
 * Created by vitaly on 07.09.15.
 */
public abstract class Shape extends Observable{
    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
}
