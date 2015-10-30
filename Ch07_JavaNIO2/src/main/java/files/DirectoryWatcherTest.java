package files;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;

import static java.nio.file.StandardWatchEventKinds.*;
import static java.util.Collections.emptyMap;

public class DirectoryWatcherTest {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/vitaly/IdeaProjects/OCP/Ch07_JavaNIO2/src/main/resources/test");
        int i = 0;
        try(WatchService whatcer = FileSystems.getDefault().newWatchService();) {
            dir.register(whatcer, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            while (true) {
                WatchKey key = null;
                try {
                    key = whatcer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

                List<WatchEvent<?>> events = key.pollEvents();

                final boolean valid = key.reset();

                if (!valid) {
                    break;
                }

                for (WatchEvent<?> e : events) {
                    final WatchEvent.Kind<?> kind = e.kind();
                    if (kind == OVERFLOW) {
                        continue;
                    }

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> event = (WatchEvent<Path>) e;
                    Path path = (Path) key.watchable();
                    Path file = path.resolve(event.context());
                    try {
                        System.out.printf("%d-%s file '%s' has been '%s'%n", i++, Files.getLastModifiedTime(file).toMillis(), file, kind);
//                    String contentType = Files.probeContentType(file);
//                    if (contentType == null) {
//                        System.out.printf("file '%s' has been '%s'%n", file, kind);
//                    } else {
//                        System.out.printf("'%s' file '%s' has been '%s%n'", contentType, file, kind);
//                    }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        continue;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
