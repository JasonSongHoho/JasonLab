package lab.test;

import java.util.function.Consumer;

/**
 * @author jasonsong
 * 2020/7/22
 */


public class ConsumerTest {

    public static void main(String[] args) {
        DemoConsumer demoConsumer=new DemoConsumer(1);
        demoConsumer.accept("test");
    }
}
