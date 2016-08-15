package OCP;

import print.PrintUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world! *
 */
public class App {
    public static final String ROOT_PATH_NAME = "Ch06_JavaIOFundamentals/src/main/resources/";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArray);
        A b = new B();
        out.writeObject(b);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byteArray.toByteArray()));
        PrintUtils.printDelimiterString();
        Object b1 = in.readObject();
        PrintUtils.printDelimiterString();
//        Path p1 = Paths.get("a/b/c/./../d");
        Path p1 = Paths.get("a/b/c/d");
        Path p2 = Paths.get("a/b/c/c/d");
        System.out.println(p1.normalize());
        Path relativize = p1.relativize(p2);
        System.out.println(relativize);
        System.out.println(p1.resolve(relativize).normalize());
    }
}

class A {
    {
        System.out.println("Instance");
    }
    public A() {
        System.out.println("A");
    }
}

class B extends A implements Serializable{
    public B() {
        System.out.println("B");
    }
}