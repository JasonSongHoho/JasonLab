package lab.test.jave;

import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;

import java.io.File;

/**
 * @author Jason/XiaoJie
 * @date 2021/6/15
 */
public class Test {
    //Converting any audio to mp3
    public static void main(String[] args) {
        boolean succeeded;
        try {
            File source = new File("/Users/songjisong/Documents/demo52.mp4");
            File target = new File("/Users/songjisong/Documents/demoAudio52.mp3");

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(128000);
            audio.setChannels(2);
            audio.setSamplingRate(44100);

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setOutputFormat("mp3");
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            ex.printStackTrace();
            succeeded = false;
        }
    }
}
