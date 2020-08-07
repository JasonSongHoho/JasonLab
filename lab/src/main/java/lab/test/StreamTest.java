package lab.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author jasonsong
 * 2020/8/7
 */


public class StreamTest {
    public static void main(String[] args) {
        List<String> list = CollectionUtil.newArrayList(null, "", "123", "1234");
        List<String> filterCollect = list.parallelStream().filter(s -> !StrUtil.isEmpty(s))
                .collect(Collectors.toList());
        System.out.println(filterCollect.toString());

        List<Object> mapCollect = list.parallelStream().map((Function<String, Object>) s -> {
            if (s == null) {
                return null;
            }
            return s + "2";
        }).collect(Collectors.toList());
        System.out.println(mapCollect.toString());

        int sum = list.parallelStream().filter(s -> !StrUtil.isEmpty(s)).
                mapToInt(Integer::valueOf).sum();
        System.out.println(sum);

        List<Integer> list1 = CollectionUtil.newArrayList(1, 5, 3, 8, 5, 9);
        List<Integer> sortedCollect = list1.parallelStream().sorted().collect(Collectors.toList());
        System.out.println(sortedCollect.toString());

        list.parallelStream().forEach(s -> System.out.println("forEach " + s));

        Optional<Integer> reduceResult = list1.parallelStream().reduce((integer, integer2) -> integer + integer2);

        System.out.println("reduceResult:" + reduceResult.get());
    }
}
