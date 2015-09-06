package local_inner_class;

import java.util.Locale;

/**
 * Created by Vitaly on 06.09.2015.
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        Shape.Color simpleColor = new Shape.Color(15, 56, 254);
        Shape.Color descriptiveColor = StatusReporter.getDescriptiveColor(simpleColor);
        System.out.println(simpleColor);
        System.out.println(descriptiveColor);
        Shape.Colored colored = new Shape.Colored() {
        };
    }
}

 class Shape  {
    public static class Color {
        private int r, g, b;

        static {
            String s = "";
        }

        public Color() {
        }

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getG() {
            return g;
        }

        public void setG(int g) {
            this.g = g;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("red=").append(r);
            sb.append(", green=").append(g);
            sb.append(", blue=").append(b);

            return sb.toString();
        }
    }

    public  interface Colored {
        default Shape getString(){
            class StringShape extends Shape {

            }
            return new StringShape();
        }
    }
}

class StatusReporter {
    //    String string;
    public String g;
    public static Shape.Color getDescriptiveColor(Shape.Color color) {
        String string = color.toString();
//        color = new Shape.Color();

        class DescriptiveColor extends Shape.Color {
            static final String sdfs = "asdf";
            DescriptiveColor() {
                super(color.getR(), color.getG(), color.getB());
                String str = string.getBytes().toString();
            }

//            public static void remove() {
//
//            }

            @Override
            public String toString() {
                return "You selected a color with RGB values " + super.toString() + string + color;
            }
        }
        DescriptiveColor descriptiveColor = new DescriptiveColor();
//        string = "sdf";
        return descriptiveColor;
    }
}
