package lab.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasonsong
 * 2020/9/11
 */


public class GenericTypeLab {
    public static void main(String[] args) {
        List<? extends Object> list = new ArrayList<>();
//        list.add("ab");
        List<Object> list1 = new ArrayList<>();
        list1.add("ab");
    }
}
