package annotations;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * Created by vitaly on 08.09.15.
 */
@Filter("main")
@Filter("second")
@Filter
@MyAnnotation1("A1")
public class A {
    public static void main(String[] args) {
        A b = new B();
        AnnotatedElement bClass = b.getClass();
        Annotation[] annotations = bClass.getAnnotations();
        Annotation[] declaredAnnotations = bClass.getDeclaredAnnotations();
        Annotation[] repeatableAnnotations = bClass.getAnnotationsByType(Filter.class);

        System.out.println(Arrays.toString(annotations));
        System.out.println();
        System.out.println(Arrays.toString(declaredAnnotations));
        System.out.println();
        System.out.println(Arrays.toString(repeatableAnnotations));
    }
}
@MyAnnotation2("A3")
class B extends A {
    public B(String... strings) {
    }
}

/**
 * Created by vitaly on 08.09.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyAnnotation1 {
    String value() default "A1";
}

/**
 * Created by vitaly on 08.09.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyAnnotation2 {
    String value() default "A2";
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Filters {
    Filter[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Repeatable(Filters.class)
@interface Filter {
    String value() default "F";
}