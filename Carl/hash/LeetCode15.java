package com.carl.hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode15 {

    /**
     * 题目链接：https://leetcode.cn/problems/3sum/
     */

    /**
     * 思路：采用双指针：首先对数组排序，然后定义一个for循环遍历数组，左指针left为i+1，又指针right为数组结尾
     *      当a[i]+a[left]+a[right] > 0时则right--
     *                              <    left++
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //创建一个结果结合
        List<List<Integer>> res = new LinkedList<>();
        //对数组进行排序
        Arrays.sort(nums);
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //当没有满足条件的结果
            if (nums[i] > 0) {
                return res;
            }
            //当此轮a[i]与上一轮a[i-1]相同时则继续下一轮循环
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //定义双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                //计算三指针之和
                int sum = nums[i] + nums[left] + nums[right];
                //判断大小
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    //满足条件加入结果集
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //其实为去重操作
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;

                }
            }
        }
        return res;
    }
}
