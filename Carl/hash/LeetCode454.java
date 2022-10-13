package com.carl.hash;

import java.util.HashMap;
import java.util.Map;

public class LeetCode454 {

    /**
     * 题目链接：https://leetcode.cn/problems/4sum-ii/
     */
    /**
     * 思路：这里先计算1，2数组俩个数组中数字之和，并统计每个数字出现的次数，然后在统计3，4数组判断是否满足条件
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //创建一个哈希表，键存放1，2俩数组每个数字之和，值存放相应地出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1: nums1) {
            for (int n2: nums2) {
                int temp = n1 + n2;
                //判断此键是否出现过
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        int res = 0;
        //再遍历3，4数组找到满足的个数
        for (int n1 : nums3) {
            for (int n2: nums4) {
                int temp = n1 + n2;
                //判断是否满足条件
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }
        return res;
    }
}
