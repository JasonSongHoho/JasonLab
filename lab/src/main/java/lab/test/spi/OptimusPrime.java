package lab.test.spi;

/**
 * @author jasonsong
 * 2020/8/21
 */


public class OptimusPrime implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}
