package lab.test.jave;

import lombok.extern.slf4j.Slf4j;
import ws.schild.jave.VideoProcessor;
import ws.schild.jave.progress.EchoingProgressListener;
import ws.schild.jave.utils.AutoRemoveableFile;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ConcatDemuxerTest {

    public static void main(String[] args) {
        VideoProcessor vps = new VideoProcessor();

        List<File> videos =
                Stream.of(
                        "/Users/songjisong/Documents/composeSrc/daily_emotion/video/head.mp4",
                        "/Users/songjisong/Documents/composeSrc/daily_emotion/video/end.mp4")
                        .map(File::new)
                        .collect(Collectors.toList());

        try (AutoRemoveableFile destination = new AutoRemoveableFile(new File("/Users/songjisong/Documents/composeDemo"), "merge.mp4")) {
            vps.catClipsTogether(videos, destination, new EchoingProgressListener("Test Merge"));
            System.out.println(destination.getPath());
        } catch (Exception exception) {
            log.error("", exception);
        }
    }

}
