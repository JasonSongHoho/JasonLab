package lab.test;

/**
 * @author jasonsong
 * 2020/7/22
 */


public class LambadaTest {
    private DemoInterface demoInterface;

    public LambadaTest(DemoInterface demoInterface) {
        this.demoInterface = demoInterface;
    }

    public static void main(String[] args) {
        LambadaTest lambadaTest = new LambadaTest(src -> {
            System.out.println(src);
        });
        lambadaTest.demoInterface.demoMethod("hello");

    }
}
