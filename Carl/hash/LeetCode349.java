package com.carl.hash;

import java.util.HashSet;
import java.util.Set;

public class LeetCode349 {

    /**
     * 题目链接：https://leetcode.cn/problems/intersection-of-two-arrays/
     */
    /**
     *  思路：创建俩个set集合，先将一个数组中元素放入集合中，再遍历另一个数组判断此元素是否在集合中
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        //创建set集合1
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> resSet = new HashSet<Integer>();
        //将数组num1中的元素放入集合1中
        for (int num: nums1) {
            set1.add(num);
        }
        //遍历数组num2判断是否元素在哈希表中
        for (int num: nums2) {
            if (set1.contains(num)) {
                resSet.add(num);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }
}
