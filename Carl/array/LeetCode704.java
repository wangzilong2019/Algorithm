package com.carl.array;

public class LeetCode704 {
    //采用二分查找进行搜索
    // 这里注意左右指针每次=mid+1或是mid-1，写的时候设置了=mid，因为循环条件是l<=r会出现死循环
    // 因为有循环条件l<r控制循环，不用担心指针溢出问题
    public int search(int[] nums, int target) {
        //判断输入是否非法
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //设置二分搜索左右指针
        int l = 0;
        int r = nums.length - 1;
        //进行二分搜索
        while (l <= r) {
            //判断是否等于目标值
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        //不存在target则返回-1
        return -1;
    }
}
