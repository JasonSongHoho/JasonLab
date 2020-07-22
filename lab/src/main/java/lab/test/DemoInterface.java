package lab.test;

/**
 * @author jasonsong
 * 2020/7/22
 */


public interface DemoInterface {
    void demoMethod(String a);

    default void demoMethod1(String a){}


}
