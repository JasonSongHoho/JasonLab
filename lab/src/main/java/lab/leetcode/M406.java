package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @author jasonsong
 * 2018/12/22
 */


public class M406 {
    private static final Logger LOGGER = LoggerFactory.getLogger(M406.class);

    public static void main(String[] args) {
        M406 m406 = new M406();

        int[][][] peopleArr = {{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}};
        for (int[][] people : peopleArr) {
            LOGGER.info("input:{},output:{}", people, m406.reconstructQueue(people));
        }


    }

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];

            }
        });
        int n = people.length;
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }

        int[][] ret = new int[n][2];
        for (int i = 0; i < n; i++) {
            ret[i][0] = tmp.get(i)[0];
            ret[i][1] = tmp.get(i)[1];
        }
        return ret;
    }

}
