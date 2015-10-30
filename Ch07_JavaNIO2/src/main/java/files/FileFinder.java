package files;

import OCP.App;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

import static java.nio.file.FileVisitResult.*;

/**
 * Created by vitaly on 29.10.15.
 */
public class FileFinder extends SimpleFileVisitor<Path>{
    private ThreadLocal<List<Path>> findedFiles = new ThreadLocal<>();
    private final PathMatcher matcher;

    public FileFinder(PathMatcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        addPathIfMatch(dir);

        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        addPathIfMatch(file);

        return CONTINUE;
    }

    public List<Path> find(String path) {
        return find(Paths.get(path));
    }

    public List<Path> find(Path dir) {
        prepareFileList();

        try {
            Files.walkFileTree(dir, this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return findedFiles.get();
    }

    private void prepareFileList() {
        findedFiles.set(new LinkedList<>());
    }

    private void addPathIfMatch(Path dir) {
        if (matcher.matches(dir.getFileName())) {
            findedFiles.get().add(dir);
        }
    }

    public static void main(String[] args) {
        String pattern = "*.txt";
        PathMatcher globMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        FileFinder finder = new FileFinder(globMatcher);
        System.out.println(finder.find("."));
    }
}
