package com.carl.array;

public class LeetCode283 {
    /**
     * 题目链接：https://leetcode.cn/problems/move-zeroes/
     * @param nums
     */
    /**
     * 采用快慢指针方式
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //定义快慢指针
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }
        for (j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());
    }
}
