package ekel;

/**
 * Created by vitaly on 24.11.15.
 */
public class Restaurant {
    public Meal meal;
}

class Meal {
    private final int orderNum;

    Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Meal{");
        sb.append("orderNum=").append(orderNum);
        sb.append('}');
        return sb.toString();
    }
}

//abstract class RestoraunPersonal implements Runnable {
//    private final Restaurant restaurant;
//
//    RestoraunPersonal(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }
//
//}
//
//class WaitPerfon extends RestoraunPersonal {
//    WaitPerfon(Restaurant restaurant) {
//        super(restaurant);
//    }
//
//    @Override
//    public void run() {
//        while (!Thread.interrupted()) {
//            if
//        }
//    }
//}