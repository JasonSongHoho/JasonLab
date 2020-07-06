package lab.test;

/**
 * @author jasonsong
 * 2020/7/5
 */


public class StringTest {
    public static void main(String[] args) {
        String a="jasonsong";
        String b=new String("jasonsong");
        String c="jason"+"song";

        //false
        System.out.println(a==b);
        //true
        System.out.println(a==c);
        //true
        System.out.println(a.equals(b));
        //true
        System.out.println(a.equals(c));
        //true
        System.out.println(a.intern()==b.intern());


    }
}
