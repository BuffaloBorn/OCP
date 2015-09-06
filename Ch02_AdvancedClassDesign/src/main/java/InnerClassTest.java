/**
 * Created by Vitaly on 06.09.2015.
 */
class Shape {
    private static String hiddenStaticField = "Hidden field";
    public static class Color {
        public static String string;
        private int red, green, blue;

        public Color() {
            this(0, 0, 0);
        }

        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public String getHiddenField() {
            return hiddenStaticField;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public int getBlue() {
            return blue;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("red=").append(red);
            sb.append(", green=").append(green);
            sb.append(", blue=").append(blue);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Color color = new Color();
        color.blue = 10;
    }
}

public class InnerClassTest {
    public static void main(String[] args) {
        Shape.Color color = new Shape.Color(5, 6, 8);
        String s = color.getHiddenField();
//        Shape.Color color1 = new Shape().Color(); // Нельзя создавать через экземпляр внешнего класса!!!
        System.out.println(color);
        System.out.println(s);
        System.out.println();
    }
}
