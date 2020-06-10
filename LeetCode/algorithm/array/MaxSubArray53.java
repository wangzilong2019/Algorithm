package leetcode.algorithm.array;

public class MaxSubArray53 {
    public int maxSubArray(int[] nums) {
        //从结果进行分析动态规划思想
        /**
         当sum > 0 时对最大值有溢增
         当sum <= 0 时，对最大值无溢增
         仔细想一下，若当前结果为负数，无论下一个是正数还是负数，相加只会比下一个小
         */
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }

            //每次更新结果
            res = Math.max(sum, res);
        }

        return res;
    }
}
