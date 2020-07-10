package lab.test;

/**
 * @author jasonsong
 * 2020/7/8
 */


public class TestInteger {
    public static void main(String[] args) {
        int maxValue=Integer.MAX_VALUE;
        int minValue=Integer.MIN_VALUE;
        byte b = new Integer(-22221).byteValue();
        int i = Integer.bitCount(-21);
        System.out.println(++maxValue);
        System.out.println(minValue);
        System.out.println(b);
        System.out.println(i);
    }
}
