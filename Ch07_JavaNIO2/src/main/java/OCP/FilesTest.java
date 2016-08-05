package OCP;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

/**
 * Created by Vitaly on 04.08.2016.
 */
public class FilesTest {
    public static Path workPath = Paths.get("D:\\Java\\OCP\\Ch07_JavaNIO2\\src\\main\\java\\OCP");

    public static void main(String[] args) throws IOException {
        System.out.println(Files.isSameFile(Paths.get("/foo"), Paths.get("/foo/bar/..").normalize()));
        Path newDirectory1 = workPath.resolve("dir1");
        Path newDirectory2 = workPath.resolve("tree/tree1/tree2/1.txt");
//        Files.createDirectory(newDirectory1);
//        Files.createDirectories(newDirectory2);
//        Path target = workPath.resolve("mp3/App.java");
//        Files.copy(workPath.resolve("App.java"), target);
//        Files.delete(target);
//        Files.delete(target);
        FileTime f;
        Path appFile = workPath.resolve("App.java");
        System.out.println(f = Files.getLastModifiedTime(appFile));
        System.out.println(Files.getOwner(appFile));
        UserPrincipal owner = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("vitaly");
        System.out.println(owner);
        BasicFileAttributes v1 = Files.readAttributes(appFile, BasicFileAttributes.class);
        DosFileAttributes v2 = Files.readAttributes(appFile, DosFileAttributes.class);
        System.out.println(v1);
        System.out.println(v2);

    }

}
