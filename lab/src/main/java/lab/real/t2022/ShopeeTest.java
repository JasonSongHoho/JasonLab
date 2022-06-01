package lab.real.t2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * void getTopM(int[] array, int M)
 * output the top M frequency number from array
 * for example:
 * int[] array = {12, 34, 11, 10,9,12, 34, 78, 12}
 * if m=4, then:
 * top1:  [12, 3]
 * <p>
 * top2:  [34, 2]
 * <p>
 * top3:  [78, 1]
 * <p>
 * top4:  [11, 1]
 * <p>
 * <p>
 * void getTopM(int[] array, int M)
 * output:  12, 3\n, 34, 2\n, 78, 1\n 11, 1
 *
 * @author Jason/XiaoJie
 * @date 2022/5/31
 */
public class ShopeeTest {

    // tc: O(nlogM) n: cntMap.size()
    // sc:  O(n)
    public Set<Integer> getTopM(int[] array, int M) {
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        PriorityQueue<NumObj> queue = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
        Set<Integer> ans = new HashSet<>();
        for (int num : array) {
            int cnt = cntMap.getOrDefault(num, 0);
            cntMap.put(num, cnt + 1);
        }
        cntMap.forEach((a, b) -> {
                    queue.offer(new NumObj(a, b));
                    if (queue.size() > M) {
                        queue.poll();
                    }
                }
        );
        for (NumObj numObj : queue) {
            ans.add(numObj.num);
        }
        return ans;

    }


    public class NumObj {
        int num;
        int cnt;

        public NumObj(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
