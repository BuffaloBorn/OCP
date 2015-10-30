package OCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.IntStream;

import static java.nio.file.StandardOpenOption.*;

/**
 * Created by vitaly on 29.10.15.
 */
public class ReadStream {
    public static void main(String[] args) throws IOException {
        Path log = Paths.get("/home/vitaly/Загрузки/hs_err_pid24341.log");
        try(BufferedReader reader = Files.newBufferedReader(log);){
            reader.lines().forEach(System.out::println);
        }
        System.out.println("==============================================================================================================");
        Path errors = Paths.get("/home/vitaly/Загрузки/error.txt");
        List<String> lines = Files.readAllLines(errors);
        lines.forEach(System.out::println);
        Files.write(Paths.get("/home/vitaly/IdeaProjects/OCP/Ch07_JavaNIO2/src/main/resources/errors"), lines, WRITE, CREATE);
    }
}
