package patterns.observer;


import java.util.Observer;

/**
 * Created by vitaly on 07.09.15.
 */

public class Circle extends Shape {
    public static class Point2D {
        private final int x;
        private final int y;

        public Point2D() {
            this(0, 0);
        }

        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append('(').append(x).append(", ").append(y).append(')');

            return sb.toString();
        }

        public int getY() {
            return y;
        }
    }

    private Point2D center;

    private int radius;

    public Circle() {
        this(new Point2D(), 0);
    }

    public Circle(Point2D center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        notifyObservers(new Event<Point2D>("center", center));
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        notifyObservers(new Event<Integer>("radius", radius));
        this.radius = radius;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append("center=").append(center);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Observer observerToRemove;
        Circle circle = new Circle();
        circle.addObserver(new Canvas());
        circle.addObserver(new Canvas());
        circle.addObserver((observerToRemove = new ShapeArchiver()));
        circle.setCenter(new Point2D(5, 10));
        circle.deleteObserver(observerToRemove);
        circle.setRadius(20);
    }
}

