package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/6
 */
public class E933 {
    List<Integer> list = new ArrayList<>();
    Deque<Integer> queue = new LinkedList<>();

    public E933() {

    }

    public int ping1(int t) {
        list.add(t);
        int count;
        int i = 0;
        for (; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (integer >= t - 3000) {
                break;
            }
        }
        count = list.size() - i;
        list.subList(0, i).clear();
        return count;
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.getFirst() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

}
