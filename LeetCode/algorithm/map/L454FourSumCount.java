package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class L454FourSumCount {
    /**
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     *
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *  思路：
     *     使用map集合
     *      1、创建一个mao集合键存放a和b数组任意俩个数组之和，值存放此键出现的次数
     *      2、球c和d数组任意俩个元素之和的相反数，判断是否出现过，累加出现的次数
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //创建一个集合
        Map<Integer, Integer> map = new HashMap<>();
        //记录a和b元素之和以及出现额次数
        for (int a : A) {
            for (int b : B) {
                int sumAB = a + b;
                int count = map.getOrDefault(sumAB, 0) + 1;
                map.put(sumAB, count);
            }
        }
        int ans = 0;
        //再计算chec元素之和的相反谁，判断是否在map中出现
        for (int c : C) {
            for (int d : D) {
                int sumCD = -(c + d);
                //判断是否在map中出现
                if (map.containsKey(sumCD)) {
                    ans += map.get(sumCD);
                }
            }
        }
        return ans;
    }
}
