package com.carl.array;

public class LeetCode977 {

    /**
     * 题目链接：https://leetcode.cn/problems/squares-of-a-sorted-array/
     */
    /**
     * 思路：双指针，原数组三种可能：
     *  1、数组元组全为负值
     *  2、数组元组全为正值
     *  3、数组元素前半部分复制，后半部分正值
     *  无论哪种最大大元素一定出现在最左面或最右面
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        //创建一个新数组
        int[] arr = new int[nums.length];
        //定义新数组指针倒序存放
        int index = nums.length - 1;
        //定义双指针
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            //比较当前左右指针平方元素大小
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if (left < right) {
                arr[index--] = right;
                j--;
            } else if (left > right) {
                arr[index--] = left;
                i++;
            } else {
                arr[index--] = left;
                i++;
                j--;
            }
        }
        return arr;
    }
}
