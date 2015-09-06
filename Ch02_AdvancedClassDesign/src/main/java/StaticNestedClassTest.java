/**
 * Created by Vitaly on 06.09.2015.
 */
class Circle extends Shape {
    private int x, y;
    private int radius;
    private Point center;

    public Circle(int x, int y, int radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public class Point {
//        public static String string;
        private int x, y;

        public Point() {
            this(0, 0);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            Circle.this.x = x;
        }

        public Circle getCircle() {
            return Circle.this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("x=").append(x);
            sb.append(", y=").append(y);

            return sb.toString();
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append(center);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }

    public Point getCenter() {
        return center;
    }
}

public class StaticNestedClassTest {
    public static void main(String[] args) {
        Circle circle = new Circle(10, 10, 8);
        System.out.println(circle);
        Circle.Point point = circle.getCenter();
        System.out.println(point.getCircle() == circle);
    }
}