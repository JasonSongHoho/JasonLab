package lab.test;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * ————————————————
 * 版权声明：本文为CSDN博主「错落有致」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/liuyifeng1920/article/details/53368103
 *
 * @author jasonsong
 * 2020/7/14
 */


public class PipedWriteTest {
    public static void main(String[] args) throws IOException {

        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();

        // 做个链接才能通讯
        pipedReader.connect(pipedWriter);
        ThreadPipedReaderA a = new ThreadPipedReaderA(pipedReader);
        ThreadPipedWriteB b = new ThreadPipedWriteB(pipedWriter);
        a.start();
        b.start();

    }

    public static class ThreadPipedReaderA extends Thread {

        PipedReader pipedReader;


        public ThreadPipedReaderA(PipedReader pipedReader) {
            this.pipedReader = pipedReader;
        }

        @Override
        public void run() {

            try {
                char[] chararray = new char[20];
                int readLength = pipedReader.read(chararray);
                while (readLength != -1) {
                    String str = new String(chararray, 0, readLength);
                    System.out.println("读到的数据为：" + str);
                    readLength = pipedReader.read(chararray);

                }
                pipedReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static class ThreadPipedWriteB extends Thread {

        PipedWriter pipedWriter;


        public ThreadPipedWriteB(PipedWriter pipedWriter) {
            this.pipedWriter = pipedWriter;
        }

        @Override
        public void run() {

            try {
                for (int i = 0; i <= 10; i++) {
                    pipedWriter.write("发送数据" + i);
                }
                pipedWriter.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
