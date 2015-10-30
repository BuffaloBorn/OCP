package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

/**
 * Created by vitaly on 30.10.15.
 */
public class MIMEDeterminator {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("/home/vitaly/Загрузки");
        final Consumer<Path> pathConsumer = path -> {
            try {
                System.out.printf("%-80s\t%s%n", Files.probeContentType(path), path.getFileName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Files.list(dir).filter(path -> !Files.isDirectory(path)).sorted().forEach(pathConsumer);
    }
}

