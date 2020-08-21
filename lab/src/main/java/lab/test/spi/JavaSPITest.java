package lab.test.spi;

import java.util.ServiceLoader;

/**
 * @author jasonsong
 * 2020/8/21
 */


public class JavaSPITest {
    public static void main(String[] args) throws Exception {
        sayHello();
    }

    public static void sayHello() throws Exception {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
