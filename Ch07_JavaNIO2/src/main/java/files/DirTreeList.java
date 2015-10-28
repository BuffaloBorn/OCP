package files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Consumer;

/**
 * Created by vitaly on 28.10.15.
 */
public class DirTreeList {
    public static Consumer<Path> PATH_PRINTER = path -> {
        String prefix = String.valueOf(new char[path.getNameCount()]).replace("\0", "\t");
        System.out.print(prefix);
        System.out.printf("%s%n", path.getFileName());
    };

    public static FileVisitor<Path> MY_TREE_VISITOR = new SimpleFileVisitor<Path>(){
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            PATH_PRINTER.accept(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            PATH_PRINTER.accept(dir);
            return FileVisitResult.CONTINUE;
        }
    };

    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("");
        Files.walkFileTree(dir, MY_TREE_VISITOR);
    }
}

