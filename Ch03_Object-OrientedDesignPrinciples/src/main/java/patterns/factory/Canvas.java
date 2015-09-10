package patterns.factory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vitaly on 07.09.15.
 */
public class Canvas {
    private final List<Shape> shapeList = new LinkedList<>();
    private final AbstracrShapeFactory abstracrShapeFactory = new AbstracrShapeFactory();

    public Canvas() { }

    public void addNewShape(String shapeType, String factoryType) {
        shapeList.add(abstracrShapeFactory.getFactory(factoryType).getShape(shapeType));
    }

    public void redraw() {
        shapeList.stream().forEach(Shape::draw);
    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.addNewShape("Circle", "Display");
        canvas.addNewShape("Rectangle", "Display");
        canvas.addNewShape("Rectangle", "Print");
        canvas.redraw();
    }
}
