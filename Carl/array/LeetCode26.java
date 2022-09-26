package com.carl.array;

public class LeetCode26 {
    /**
     * 题目链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
     */
    /**
     * 快慢指针法：
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //合法性判断
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }
        //定义快慢指针
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            //当快慢指针所指向的元素相同时
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j];
                j++;
            }

        }
        return i + 1;
    }
}
