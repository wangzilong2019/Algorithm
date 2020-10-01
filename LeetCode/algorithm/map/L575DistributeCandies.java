package leetcode.algorithm.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L575DistributeCandies {
    /**
     * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/distribute-candies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 输入: candies = [1,1,2,2,3,3]
     * 输出: 3
     * 解析: 一共有三种种类的糖果，每一种都有两个。
     *      最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/distribute-candies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        //统计糖果种类数
        Set<Integer> set = new HashSet<>();
        for (int can : candies) {
            set.add(can);
        }
        return set.size() >= candies.length / 2 ? candies.length / 2 : set.size();
    }

    /**
     *  方法二：
     *     首先给数组排序，通过统计不同个数来判断
     * @param candies
     * @return
     */
    public int distributeCandies2(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++) {
            if (candies[i] > candies[i-1]) {
                count++;
            }
        }
        return count;
    }
}
