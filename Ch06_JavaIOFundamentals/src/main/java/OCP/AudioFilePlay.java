package OCP;

//import javax.media.*;
//import javax.media.format.AudioFormat;
//import javax.sound.sampled.*;
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Vitaly on 04.08.2016.
 */
public class AudioFilePlay implements LineListener {
    public static String bip = "D:\\Java\\OCP\\Ch06_JavaIOFundamentals\\src\\main\\resources\\Queen.mp3";
    /**
     * this flag indicates whether the playback completes or not.
     */
    boolean playCompleted;

    /**
     * Play a given audio file.
     *
     * @param audioFilePath Path of the audio file.
     */
    void play(String audioFilePath) throws IOException {
        File audioFile = new File(audioFilePath);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();

//            DataLine.Info info = new DataLine.Info(Clip.class, format);
            DataLine.Info info = new DataLine.Info(BigClip.class, format);

            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.addLineListener(this);

            audioClip.open(audioStream);

            audioClip.start();

            while (!playCompleted) {
                // wait for the playback completes
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            audioClip.close();

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }

    }

    /**
     * Listens to the START and STOP events of the audio line.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();

        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");

        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }

    }

    public static void main(String[] args) throws IOException {
//        String audioFilePath = "c:\\Program Files\\Logitech\\SetPointP\\Sounds\\GameAdd.wav";
        String audioFilePath = bip;
        AudioFilePlay player = new AudioFilePlay();
        player.play(audioFilePath);
//        try (InputStream is = new FileInputStream(bip)) {
//            for (int i = 0; i < 100; i++) {
//                System.out.println(is.read());
//            }
//        }
    }
//    public static void main(String[] args) throws IOException, NoPlayerException {
//        File file = new File(bip);
//        Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
//        Format input2 = new AudioFormat(AudioFormat.MPEG);
//        Format output = new AudioFormat(AudioFormat.LINEAR);
//        PlugInManager.addPlugIn(
//                "com.sun.media.codec.audio.mp3.JavaDecoder",
//                new Format[]{input1, input2},
//                new Format[]{output},
//                PlugInManager.CODEC
//        );
////        try{
//            Player player = Manager.createPlayer(new MediaLocator(file.toURI().toURL()));
//            player.start();
////        }
////        catch(Exception ex){
////            ex.printStackTrace();
////        }
//    }
}
