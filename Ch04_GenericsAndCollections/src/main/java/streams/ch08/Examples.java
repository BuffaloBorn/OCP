package streams.ch08;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Vitaly on 03.10.2015.
 */
public class Examples {
    public static void main(String[] args) {
        Compressor ZipCompressor = new Compressor(new ZipCompressionStrategy());
        Compressor LZipCompressor = new Compressor(ZipOutputStream::new);
    }
}

interface CompressionStrategy {
    OutputStream compress(OutputStream data) throws IOException;
}

class GzipCompressionStrategy implements CompressionStrategy {
    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new GZIPOutputStream(data);
    }
}

class ZipCompressionStrategy implements CompressionStrategy {
    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new ZipOutputStream(data);
    }
}

class Compressor {
    private final CompressionStrategy strategy;

    Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException{
        try (OutputStream outputStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, outputStream);
        }
    }
}