package lab.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasonsong
 * 2020/7/30
 */


public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(16);
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }

//        for (int i = 0; i < list.size(); i++) {
//            list.remove(i);
//        }

        Integer i = 0;
//        int i=0;
        for (String s : list) {
            list.remove("" + i++);
        }

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            System.out.println(next);
//            iterator.remove();
//        }

        System.out.println(list.toString());
    }
}
