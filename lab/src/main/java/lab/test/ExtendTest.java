package lab.test;

/**
 * @author jasonsong
 * 2020/7/6
 */


public class ExtendTest {
    public static void main(String[] args) {
        A a=new B();
        a=new B();
    }

}

class A{
    static {
        System.out.println("static A");
    }

    public A() {
        System.out.println("construct A");
    }
}

class B extends A{
    static {
        System.out.println("static B");
    }

    public B() {
        System.out.println("construct B");
    }
}
