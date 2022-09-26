package com.carl.array;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        //判断输入是否合法
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //设置左右指针位置
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return l;
    }
}
