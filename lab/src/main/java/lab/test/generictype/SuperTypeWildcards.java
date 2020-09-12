package lab.test.generictype;

import java.util.List;

/**
 * @author jasonsong
 * 2020/9/12
 */


public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
//        apples.add(new Fruit());  // 编译错误
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
