package lab.test.generictype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasonsong
 * 2020/9/12
 */


public class GenericsAndCovariance {
    public static void main(String[] args) {
        //泛型把类型检查移到了编译期，协变过程丢掉了类型信息，编译器拒绝所有不安全的操作。
        List<? extends Fruit> flist = new ArrayList<Apple>();
//        flist.add(new Apple());  // 编译错误
//        flist.add(new Fruit());  // 编译错误
//        flist.add(new Object());  // 编译错误
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
