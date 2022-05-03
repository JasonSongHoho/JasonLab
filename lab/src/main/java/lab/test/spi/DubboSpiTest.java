package lab.test.spi;


import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author jasonsong
 * 2020/8/21
 */


public class DubboSpiTest {
    public static void main(String[] args) throws Exception {
        sayHello();
    }

    public static void sayHello() throws Exception {
        ExtensionLoader<Robot> extensionLoader =
                ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
