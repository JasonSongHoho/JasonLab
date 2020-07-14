package lab.test;

/**
 * @author jasonsong
 * 2020/7/8
 */


public class TestInteger {
    public static void main(String[] args) {
        int maxValue=Integer.MAX_VALUE;
        int minValue=Integer.MIN_VALUE;
        byte byteValue = new Integer(-22221).byteValue();
        int i = Integer.bitCount(-21);
        System.out.println(++maxValue);
        System.out.println(minValue);
        System.out.println(byteValue);
        System.out.println(i);






        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=128;
        Integer f=128;
        Long l=3L;

        System.out.println("c==(a+b) "+(c==(a+b)));
        System.out.println("c.equals(a+b) "+(c.equals(a+b)));
        System.out.println("l==(a+b) "+(l==(a+b)));
        System.out.println("l.equals(a+b) "+(l.equals(a+b)));
        System.out.println("e.equals(f) "+(e.equals(f)));
        //-128 至 127 在常量池里
        System.out.println("c==d "+(c==d));
        System.out.println("e==f "+(e==f));

    }
}
