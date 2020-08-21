package lab.test.spi;

/**
 * @author jasonsong
 * 2020/8/21
 */


public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
