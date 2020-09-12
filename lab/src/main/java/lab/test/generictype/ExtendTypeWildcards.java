package lab.test.generictype;

import java.util.List;

/**
 * @author jasonsong
 * 2020/9/12
 */


public class ExtendTypeWildcards {
    static void readFrom(List<? extends Apple> apples) {
        Apple apple = apples.get(0);
//        Jonathan jonathan = apples.get(0);  // 编译错误
        Fruit fruit = apples.get(0);
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
