package lab.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/22
 */
public class MSJD_M_16_25 {
    public static class LRUCache {
        Map<Integer, Integer> map;
        LinkedList<Integer> list;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            list = new LinkedList<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.removeFirstOccurrence(key);
                list.add(key);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                list.removeFirstOccurrence(key);
            } else if (map.size() == capacity) {
                Integer pop = list.remove(0);
                map.remove(pop);
            }
            list.add(key);
            map.put(key, value);
        }
    }

}
