package OCP;

/**
 * Created by Vitaly on 03.08.2016.
 */

import java.io.Serializable;
import java.util.RandomAccess;

public class Animal implements Serializable {
//    private static final long serialVersionUID = 1L;
    private transient String name;
    private  String name1;
    private transient int age = 10;
    private static char type = 'C';
//    private static char type1 = 'C';

    {
        this.age = 14;
    }

    public Animal() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }

    public Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getType() {
        return type;
    }

    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
    }
}