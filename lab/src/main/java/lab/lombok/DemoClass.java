package lab.lombok;

import com.alibaba.fastjson.JSON;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jasonsong
 * 2019/4/28
 */


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Slf4j
public class DemoClass {
    private String stringFiled;
    private Integer integerFiled;

    public static void main(String[] args) {
        DemoClass demoClass = DemoClass.builder().stringFiled("test").build();
        log.error("error msg");


        val arrayListVal = new ArrayList<String>();
        var arrayListVar = new ArrayList<String>();
        val hashMapVal = new HashMap<String, Integer>();
        var hashMapVar = new HashMap<String, Integer>();
        val stringVal = "sss";
        var stringVar = "sss";
        var intVar = 123;
        var floatVar = 123.1;
        var longVar = 123L;

        stringVar = "123";
        arrayListVal.add("123");
        hashMapVal.put(stringVar, intVar);
        System.out.println(arrayListVal.get(0));

        DemoClass test = new DemoClass("test", 123);
        String string = test.toString();
        System.out.println(string);
        DemoClass demoClass1 = JSON.parseObject(string, DemoClass.class);
        System.out.println(demoClass1);
    }
}