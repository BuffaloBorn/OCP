package OCP;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.EnumSet;
import java.util.stream.Stream;

import static java.nio.file.Files.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static final String ROOT_PATH_NAME = "Ch07_JavaNIO2/src/main/resources/";
    public static final Path ROOT_PATH = Paths.get(ROOT_PATH_NAME);
    public static Path SUMMARY_PATH = App.ROOT_PATH.resolve("Summary.txt");

    public static void main( String[] args ) throws IOException {
        Path p01 = Paths.get("/home/vitaly");
        Path p02 = Paths.get("/home/vitaly/IdeaProjects/openeplatformM/ivis-oeplatform-client/target/maven-status");
//        Path p03 = Paths.get(URI.create("file:///home/vitaly/Загрузки/Master_snov [mbookz.net].txt"));
        Path p04 = FileSystems.getDefault().getPath("/home/vitaly/Загрузки/Master_snov [mbookz.net].txt");
        Path p05 = Paths.get(System.getProperty("user.home"), "Загрузки", "Master_snov [mbookz.net].txt");
        Path p00 = p04;

        System.out.printf("toString: %s%n", p00.toString());
        System.out.printf("getFileName: %s%n", p00.getFileName());
        System.out.printf("getName(0): %s%n", p00.getName(0));
        System.out.printf("getNameCount(): %s%n", p00.getNameCount());
        System.out.printf("subpath(0, 1): %s%n", p00.subpath(0, 1));
        System.out.printf("getParent(): %s%n", p00.getParent());
        System.out.printf("getRoot(): %s%n", p00.getRoot());
//        System.out.printf(": %s%n", p05.);
        System.out.printf("%s%n", p00.getName(0));

//        NORMALIZE
        Path p06 = Paths.get("/home/sally/../joe/foo");
        System.out.println(p06);
        System.out.println(p06 = p06.normalize());

//        ABSOLUTE PATH
        Path p07 = Paths.get("log.txt");
        System.out.println(p07.toAbsolutePath());

//        Resolve
        System.out.println(p06.resolve("bar"));

//        Relative
        System.out.println(p04.relativize(p01));
        System.out.println(p01.relativize(p04));

        for (Path path : p00) {
            System.out.println(path);
        }

        BasicFileAttributes attributes = readAttributes(p02, BasicFileAttributes.class);
        System.out.println(attributes.fileKey());

        System.out.println(ROOT_PATH);
        System.out.println("===================================================");

        Stream<Path> rootStream = list(Paths.get(""));
        rootStream.sorted().forEach(System.out::println);

        Path log = Paths.get("/home/vitaly/Загрузки/hs_err_pid24341.log");
        Path log2 = Paths.get("/home/vitaly/IdeaProjects/OCP/Ch07_JavaNIO2/src/main/resources/hs_err_pid24341.log");
        System.out.println("Files.exists(log) = " + exists(log));
        System.out.println("Files.notExists(log) = " + notExists(log));
        boolean isRegularFile = isRegularFile(log) && isReadable(log);// && isExecutable(log);
        System.out.println(isRegularFile);
        System.out.println(log.equals(log2));
        System.out.println(Files.isSameFile(log, log2));
        attributes = Files.readAttributes(log, BasicFileAttributes.class);
        PosixFileAttributes attributes2 = Files.readAttributes(log2, PosixFileAttributes.class);
        Object fileKey = attributes.fileKey();
        Object fileKe2 = attributes2.fileKey();
        System.out.println(fileKey.equals(fileKe2));
        final UserPrincipal owner = attributes2.owner();
        System.out.println(log.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("vitaly"));
        System.out.println("owner = " + owner);
//        UserDefinedFileAttributeView view = Files.getFileAttributeView(log, UserDefinedFileAttributeView.class);
//        String name = "ow ner";
//        ByteBuffer buf = ByteBuffer.allocate(view.size(name));
//        view.read(name, buf);
//        buf.flip();
//        String value = Charset.defaultCharset().decode(buf).toString();
//        System.out.println(value);
        final FileStore fileStore = Files.getFileStore(log);
        System.out.println(fileStore.getTotalSpace() - fileStore.getUsableSpace());



//        soutv
//        soutv
    }
}
