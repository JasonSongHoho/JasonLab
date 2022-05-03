package lab.test.jave;

import lombok.extern.slf4j.Slf4j;
import ws.schild.jave.process.ProcessWrapper;
import ws.schild.jave.process.ffmpeg.DefaultFFMPEGLocator;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @author Jason/XiaoJie
 * @date 2021/6/15
 */
@Slf4j
public class ComposeDemo {
    public Supplier<ProcessWrapper> supplier = new Supplier<ProcessWrapper>() {
        @Override
        public ProcessWrapper get() {
            DefaultFFMPEGLocator defaultFFMPEGLocator = new DefaultFFMPEGLocator();
            ProcessWrapper processWrapper = defaultFFMPEGLocator.createExecutor();

            return processWrapper;
        }
    };

    public static ProcessWrapper getProcess() {
        DefaultFFMPEGLocator defaultFFMPEGLocator = new DefaultFFMPEGLocator();
        return defaultFFMPEGLocator.createExecutor();
    }

    public static void main(String[] args1) {
        boolean succeeded;
        try {
            File head = new File("/Users/songjisong/Documents/composeSrc/daily_emotion/video/head.mp4");
            File reviewBG = new File("/Users/songjisong/Documents/composeSrc/daily_emotion/image/reviewBG.png");
            File reviewEmotions = new File("/Users/songjisong/Documents/composeSrc/daily_emotion/image/reviewEmotions.png");
            File target = new File("/Users/songjisong/Documents/composeDemo/demo01.mp4");


            DefaultFFMPEGLocator defaultFFMPEGLocator = new DefaultFFMPEGLocator();

            ProcessWrapper processWrapper = defaultFFMPEGLocator.createExecutor();
            processWrapper.addArgument("-y");
            processWrapper.addArgument("-f");
            processWrapper.addArgument("concat");
            processWrapper.addArgument("-safe");
            processWrapper.addArgument("0");
            processWrapper.addArgument("-i");
            processWrapper.addArgument("/Users/songjisong/Documents/composeSrc/srcList.txt");
            processWrapper.addArgument("-vsync");
            processWrapper.addArgument("vfr");
            processWrapper.addArgument("-pix_fmt");
            processWrapper.addArgument("yuv420p");
            processWrapper.addArgument("/Users/songjisong/Documents/composeDemo/demo08.mp4");

            //destroyOnRuntimeShutdown表示是否立即关闭Runtime
            //如果ffmpeg命令需要长时间执行，destroyOnRuntimeShutdown = false
            processWrapper.execute(true, true);
            InputStream errorStream = processWrapper.getErrorStream();

            System.out.println("errorStream：" + toString(errorStream));
            //是否执行完毕
            int exitCode = processWrapper.getProcessExitCode();
            System.out.println("exitCode：" + exitCode);
            //执行完毕，关闭
            processWrapper.destroy();
//            MultimediaObject headMultimediaObject = new MultimediaObject(head,defaultFFMPEGLocator);
//
//            List<MultimediaObject> sourceList = new ArrayList<>();
//            sourceList.add(headMultimediaObject);
//            sourceList.add(headMultimediaObject);
//
//            //Audio Attributes
//            AudioAttributes audio = new AudioAttributes();
//            audio.setCodec("libmp3lame");
//            audio.setBitRate(128000);
//            audio.setChannels(2);
//            audio.setSamplingRate(44100);
//
//            //Encoding attributes
//            EncodingAttributes attrs = new EncodingAttributes();
//            attrs.setOutputFormat("mp4");
////            attrs.setAudioAttributes(audio);
//
//            //Encode
//            Encoder encoder = new Encoder();
//            encoder.encode(sourceList, target, attrs);
        } catch (Exception ex) {
            ex.printStackTrace();
            succeeded = false;
        }
    }

    public static String toString(InputStream inputStream) {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            int result = bis.read();
            while (result != -1) {
                buf.write((byte) result);
                result = bis.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf.toString();
    }


    public void drawPic(String backgroundFile, String srcFile, String targetFile, String option) {
        ProcessWrapper processWrapper = getProcess();
        ArrayList<String> args = new ArrayList<>();
        args.add("-y");
        args.add("-i");
        args.add(backgroundFile);
        args.add("-i");
        args.add(srcFile);
        args.add("-filter_complex");
        args.add(option);
        args.add(targetFile);
        run(processWrapper, args);
    }

    public void drawText(String backgroundFile, String targetFile, String option) {
        ProcessWrapper processWrapper = getProcess();
        ArrayList<String> args = new ArrayList<>();
        args.add("-y");
        args.add("-i");
        args.add(backgroundFile);
        args.add("-vf");
        args.add(option);
        args.add(targetFile);
        run(processWrapper, args);
    }

    public void run(ProcessWrapper processWrapper, ArrayList<String> args) {
        args.forEach(processWrapper::addArgument);
        try {
            processWrapper.execute();
        } catch (Exception e) {
            log.error("processWrapper.execute error.", e);
        }
        log.info("errorStream：" + toString(processWrapper.getErrorStream()));
    }


}
