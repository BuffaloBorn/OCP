package patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vitaly on 07.09.15.
 */
public class BaseObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.getClass().getName() + " Catch event");
        if (arg instanceof Event) {
            Event event = (Event) arg;
            switch (event.getType()) {
                case CREATE:
                    System.out.println(o + " created.");
                    break;
                case UPDATE:
                    System.out.println(o + " " + event.getValueName() + " updated to " + event.getValue());
                    break;

            }
        }
        System.out.println();
    }


}
class ShapeArchiver extends BaseObserver { }

class Canvas extends BaseObserver { }