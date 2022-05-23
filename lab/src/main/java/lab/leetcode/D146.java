package lab.leetcode;

import java.util.LinkedHashMap;

/**
 * @author jasonsong
 * 2018/12/24
 */


public class D146 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(1, 1);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    static class LRUCache {
        public int capacity;
        public LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>(capacity, 0.75F, true);
            map = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            map.remove(key);
            if(map.size() >= capacity){
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }
    }
}
