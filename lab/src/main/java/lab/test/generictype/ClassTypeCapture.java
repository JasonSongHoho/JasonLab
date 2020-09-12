package lab.test.generictype;

/**
 * @author jasonsong
 * 2020/9/12
 */


public class ClassTypeCapture<T> {


    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public static void main(String[] args) {
        ClassTypeCapture<C1> ctt1 = new ClassTypeCapture<>(C1.class);
        System.out.println(ctt1.f(new C1()));
        System.out.println(ctt1.f(new C2()));
        ClassTypeCapture<C2> ctt2 = new ClassTypeCapture<>(C2.class);
        System.out.println(ctt2.f(new C1()));
        System.out.println(ctt2.f(new C2()));
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    static class C1 {
    }

    static class C2 {
    }

}
