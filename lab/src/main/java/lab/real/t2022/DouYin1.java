package lab.real.t2022;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/1
 */
public class DouYin1 {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");
        List<Integer> list = topK(new int[]{4, 5, 16, 2, 7, 3, 10, 9}, 4);
        System.out.println(list.toString());
    }

    public static List<Integer> topK(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.stream().collect(Collectors.toList());
    }
}
