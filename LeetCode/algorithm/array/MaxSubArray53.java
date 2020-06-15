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

    /**
     使用动态规划解题
     dp[i] 代表到num[i]的最优解
     当dp[i-1] > 0 时  dp[i] = dp[i-1] + nums[i]
     当dp[i-1] < 0 时  dp[i] = nums[i];

     */
    public int maxSubArray2(int[] nums) {
        //判断传入数组是否有效
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        //冬天规划求解
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            //求解
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
