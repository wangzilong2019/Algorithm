package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class L447NumberOfBoomerangs {
    /**
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     *
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 输入:
     * [[0,0],[1,0],[2,0]]
     *
     * 输出:
     * 2
     *
     * 解释:
     * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *  解法一：
     *    暴力解法
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (distance(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public boolean distance(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) == (x1-x3)*(x1-x3) + (y1-y3)*(y1-y3);
    }


    /**
     * 方法二：
     *   使用map集合
     *     到A点相同距离的点个数为n个，则可能的所有组合为 n*(n-1)
     *     遍历所有点相加即可得到结果
     * @param points
     * @return
     */
    public static int numberOfBoomerangs2(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                System.out.println(distance(points[i][0], points[i][1], points[j][0], points[j][1]));
                int count = map.getOrDefault(distance(points[i][0], points[i][1], points[j][0], points[j][1]), 0) + 1;
                map.put(distance(points[i][0], points[i][1], points[j][0], points[j][1]), count);
            }

            //判断与第i个点相同距离的点个数是否大于2个
            for (int cnt : map.values()) {
                //这里可以不用加判断因为 1或是0时结果都为0
                if (cnt >= 2) {
                    res += cnt * (cnt - 1);
                }
            }
        }
        return res;

    }

    public static int distance(int x1, int y1, int x2, int y2) {
        return (x1-x2) * (x1-x2) + (y1- y2) * (y1 - y2);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs2(arr));
    }
}
