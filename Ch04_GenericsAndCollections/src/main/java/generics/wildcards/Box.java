package generics.wildcards;

/**
 * Created by vitaly on 10.09.15.
 */
public class Box<T> {
    private T t;

    public Box() {
    }

    Box(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void add(T t) { }

    public <N extends Number> void inspect(N n) {
        System.out.println(n);
    }

    public <XYZ extends X & Y & Z>void foo(XYZ xyz) { }

    public void set(T u) {

    }
//    public <XYZ extends Y & Z & X >void foo(XYZ xyz) { } // Класс должен быть первым...
//    public <XYZ extends X & Box & Y & Z>void foo2(XYZ xyz) { } ...и только один

}
