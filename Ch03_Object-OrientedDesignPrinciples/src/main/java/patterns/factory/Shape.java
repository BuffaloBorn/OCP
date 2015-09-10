package patterns.factory;

/**
 * Created by vitaly on 07.09.15.
 */
abstract class Shape implements Drowable{
    @Override
    public void draw() {
        System.out.println(getClass().getSimpleName() + " drowing...");
    }
}

interface FineDispleyShape extends Drowable { }

interface FinePrintShape extends Drowable { }

class BaseRectangle  extends Shape{
    int h, w;

    public BaseRectangle(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseRectangle{");
        sb.append("h=").append(h);
        sb.append(", w=").append(w);
        sb.append('}');
        return sb.toString();
    }
}

class BaseCircle extends Shape{
    int x, y, r;

    public BaseCircle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseCircle{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", r=").append(r);
        sb.append('}');
        return sb.toString();
    }
}

class FinePrintRectangle extends BaseRectangle implements FinePrintShape {
    public FinePrintRectangle(int h, int w) {
        super(h, w);
    }
}
class FineDisplayRectangle extends BaseRectangle implements FineDispleyShape {
    public FineDisplayRectangle(int h, int w) {
        super(h, w);
    }
}

class FinePrintCircle extends BaseCircle implements FinePrintShape {
    public FinePrintCircle(int x, int y, int r) {
        super(x, y, r);
    }
}

class FineDisplayCircle extends BaseCircle implements FineDispleyShape {
    public FineDisplayCircle(int x, int y, int r) {
        super(x, y, r);
    }
}

interface ShapeFactory {
    Shape getShape(String type);
}

class FinePrintFactory implements ShapeFactory {
    @Override
    public Shape getShape(String type) {
        switch (type) {
            case "Circle":
                return new FinePrintCircle(0, 0, 0);
            case "Rectangle":
                return new FinePrintRectangle(0, 0);
            default:
                return null;
        }
    }
}
    class FineDisplayFactory implements ShapeFactory {
    @Override
    public Shape getShape(String type) {
        switch (type) {
            case "Circle":
                return new FineDisplayCircle(0,0,0);
            case "Rectangle":
                return new FineDisplayRectangle(0,0);
            default:
                return null;
        }
    }
}

class AbstracrShapeFactory {
    ShapeFactory getFactory(String type) {
        switch (type) {
            case "Display":
                return new FineDisplayFactory();
            case "Print":
                return new FinePrintFactory();
            default:
                return null;
        }
    }
}

