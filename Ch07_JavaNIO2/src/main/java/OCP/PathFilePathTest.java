package OCP;

import print.PrintUtils;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PathFilePathTest {
    public static void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null) {
            System.out.println("   Current parent is: " + currentParent);
        }
    }

    public static void main(String[] args) throws IOException {
        printPathInformation(Paths.get("/zoo/armadillo/shells.txt"));
        PrintUtils.printDelimiterString();
        Path path = Paths.get("armadillo/shells.txt");
        printPathInformation(path);
        PrintUtils.printDelimiterString();
        System.out.println(path.isAbsolute());
        System.out.println(path.toAbsolutePath());
        System.out.println(Paths.get("too").equals(Paths.get("foo/../too").normalize()));

        PrintUtils.printDelimiterString();
        path = Paths.get("C:/mammal/carnivore/raccoon.image");
        System.out.println("Path is: " + path);
        System.out.println("Subpath from 0 to 3 is: " + path.subpath(0, 3));
        System.out.println("Subpath from 1 to 3 is: " + path.subpath(1, 3));
        System.out.println("Subpath from 1 to 2 is: " + path.subpath(1, 2));
        PrintUtils.printDelimiterString();
        path = Paths.get("foo/bar/1.txt").relativize(Paths.get("foo/2.txt"));
        System.out.println(path);
        PrintUtils.printDelimiterString();
        path = Paths.get("foo/../bar/./././1.txt").resolve(Paths.get("foo/2.txt")).normalize();
        System.out.println(Paths.get("foo/bar/1.txt").relativize(Paths.get("foo/2.txt")).normalize());
        PrintUtils.printDelimiterString();
        System.out.println(Paths.get("foo/bar/1.txt").resolveSibling(Paths.get("foo/bar/2.txt")));
        PrintUtils.printDelimiterString();
        System.out.println(Paths.get("Ch07_JavaNIO2\\src\\main\\java\\OCP\\PathFilePathTest.java").toRealPath(LinkOption.NOFOLLOW_LINKS));
    }
}