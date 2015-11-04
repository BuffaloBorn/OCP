import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by vitaly on 03.11.15.
 */
public class ForkBlur extends RecursiveAction {
    protected static int threshold = 10000;

    private int[] source;
    private int[] result;
    private int start;
    private int length;
    private int blurWidth = 15;

    public ForkBlur(int[] source, int start, int length, int[] result) {
        this.source = source;
        this.start = start;
        this.length = length;
        this.result = result;
    }

    @Override
    protected void compute() {
        if (length < threshold) {
            computeDirectly();
            return;
        }

        invokeAll(devide());
    }

//    protected void computeDirectly() {
//        int sidePixels = (blurWidth - 1) / 2;
//        final int end = start + length;
//        for (int i = start; i < end; i++) {
//
//            float r = 0, g = 0, b = 0;
//            for (int mi = -sidePixels; mi <= sidePixels; mi++) {
//                int mindex = Math.min(Math.max(mi + i, 0), source.length - 1);
//                int pixel = source[mindex];
//                r += ((pixel & 0x00ff0000) >> 16) / blurWidth;
//                g += ((pixel & 0x0000ff00) >> 8) / blurWidth;
//                b += ((pixel & 0x000000ff) >> 0) / blurWidth;
//            }
//
//            int resultPixel = 0xff000000 | ((int) r << 16) | ((int) g << 8) | ((int) b << 0);
//            result[i] = resultPixel;
//        }
//    }
// Average pixels from source, write results into destination.
protected void computeDirectly() {
    int sidePixels = (blurWidth - 1) / 2;
    for (int index = start; index < start + length; index++) {
        // Calculate average.
        float rt = 0, gt = 0, bt = 0;
        for (int mi = -sidePixels; mi <= sidePixels; mi++) {
            int mindex = Math.min(Math.max(mi + index, 0), source.length - 1);
            int pixel = source[mindex];
            rt += (float) ((pixel & 0x00ff0000) >> 16) / blurWidth;
            gt += (float) ((pixel & 0x0000ff00) >> 8) / blurWidth;
            bt += (float) ((pixel & 0x000000ff) >> 0) / blurWidth;
        }

        // Re-assemble destination pixel.
        int dpixel = (0xff000000)
                | (((int) rt) << 16)
                | (((int) gt) << 8)
                | (((int) bt) << 0);
        result[index] = dpixel;
    }
}
    protected ForkBlur[] devide() {
        int split = length / 2;

        ForkBlur[] forks = new ForkBlur[2];
        forks[0] = new ForkBlur(source, start, split, result);
        forks[1] = new ForkBlur(source, start + split, length - split, result);

        return forks;
    }

    public static BufferedImage blur(BufferedImage sourceImg) {
        int w = sourceImg.getWidth();
        int h = sourceImg.getHeight();

        int[] src = sourceImg.getRGB(0, 0, w, h, null, 0, w);
        int[] res = new int[src.length];

        System.out.println("Array size is " + src.length);
        System.out.println("Threshold is " + threshold);

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.printf("%d processor available%n", processors);

        ForkBlur fb = new ForkBlur(src, 0, src.length, res);

        ForkJoinPool pool = new ForkJoinPool();

        long startTime = System.currentTimeMillis();
        pool.invoke(fb);
        long endTime = System.currentTimeMillis();

        System.out.println("Image blur took " + (endTime - startTime) +
                " milliseconds.");

        BufferedImage dstImage =
                new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        dstImage.setRGB(0, 0, w, h, res, 0, w);

        return dstImage;
    }
}

class ForkBlurTest {
    public static void main(String[] args) throws IOException {
        String srcName = "/home/vitaly/Загрузки/U2sFryYKzN0.jpg";
        File srcFile = new File(srcName);
        BufferedImage image = ImageIO.read(srcFile);

        System.out.println("Source image: " + srcName);

        BufferedImage blurredImage = ForkBlur.blur(image);

        String dstName = "/home/vitaly/Загрузки/Single_yellow_tulip_in_a_field_of_red_tulipsB.JPG";
        File dstFile = new File(dstName);
        ImageIO.write(blurredImage, "jpg", dstFile);

        System.out.println("Output image: " + dstName);
    }
}