package bit.algorithm.dp;

import java.util.Arrays;

public class JZ30FindGreatestSumOfSubArray {

    /**
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
     * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
     * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
     * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     */

    /**
     * 动态规划：动态规划方程
     * dp[i] = max(dp[i-1] + arr[i], arr[i])
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        //定义变量存储每次计算的结果
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1] + array[i], array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划优化：
     * total代表求前i最大连续元素和时前i-1最大元素连续和
     * 若total > 0 则为正增长，total < 0 则为负增长
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        int total = array[0];
        int max = array[0];
        //total为前i-1元素的最大连续元素和,若大于0就是正增长，小于零即为负增长
        for (int i = 1; i < array.length; i++) {
            if (total >= 0) {
                total += array[i];
            } else {
                total = array[i];
            }
            if (max < total) {
                max = total;
            }
        }
        return max;
    }
}
