package com.carl.array;

public class LeetCode209 {
    /**
     * 思路：采用滑动窗口，不断动态调节滑动窗口起始位置，从而达到最优解
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        //定义滑动窗口起始和结束位置
        int left = 0;
        int right = 0;
        //记录滑动窗口元素和
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            //计算滑动窗口之和
            sum += nums[right];
            //根据目标值调节滑动窗口起始位置
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }
}
