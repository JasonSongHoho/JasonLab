package lab.test.generictype;

/**
 * @author jasonsong
 * 2020/9/12
 */


public class CovariantArrays {
    //运行时报错：
    //java.lang.ArrayStoreException: lab.test.generictype.Fruit
    //java.lang.ArrayStoreException: lab.test.generictype.Orange
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        try {
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static class Fruit {
    }

    static class Apple extends Fruit {
    }

    static class Jonathan extends Apple {
    }

    static class Orange extends Fruit {
    }


}
