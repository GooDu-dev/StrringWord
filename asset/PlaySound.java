package asset;

import java.io.File;
import javax.sound.sampled.*;

public class PlaySound {
public void play(){
        try {
            File soundFile = new File("asset/sound/cute-background.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundFile));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }
}