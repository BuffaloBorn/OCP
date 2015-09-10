package generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 09.09.15.
 */
public class GenericTest1 {
    static {
        final Class<?> aClass = new Object() {
        }.getClass();
        System.out.println(aClass.getEnclosingMethod());
    }
    public static <S> Class<?> convert(S s) {
//        Object.class.newInstance()
//        return T.class.getConstructor().newInstance();
        final Class<?> aClass = new Object() {
        }.getClass();
        final Method enclosingMethod = aClass.getEnclosingMethod();
        System.out.println(enclosingMethod.getGenericParameterTypes());
        System.out.println(aClass.getEnclosingMethod());

        return aClass;
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        List list1 = new ArrayList<String>();
        List list12 = new ArrayList<>();
        List<?> list3 = new ArrayList<Integer>();
        List<Integer> list4 = new ArrayList<>();
        List<String> list5 = new ArrayList();
        List<? extends B>  list6 = new ArrayList<>();
        Class<?> c = GenericTest1.<Integer>convert(10);
        System.out.println(c.getEnclosingMethod().getName());
//        List<Number> list6 = new ArrayList<Integer>();
//        List<Integer> list7 = new ArrayList<Number>();
//        List<> list = new ArrayList<String>();

//        list6.add(new B());
    }
}

class A implements I
{ }

class B extends A implements I
{ }

class C
{ }

interface I {

}