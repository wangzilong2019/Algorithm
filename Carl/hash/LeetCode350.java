package com.carl.hash;

import java.util.Arrays;

public class LeetCode350 {

    /**
     * 题目链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii/
     */

    /**
     * 思路：排序+双指针：首先对数组排序，然后遍历数组，党俩指针元素相同分别后移，否则较小的后移，当一个指针遍历结束后结束
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        //首先对数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //定义双指针
        int i = 0;
        int j = 0;
        int index = 0;
        //创建集合存储结果
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        //遍历数组
        while (i < nums1.length && j < nums2.length) {
            //判断俩个元素是否相同
            if (nums1[i] == nums2[j]) {
                res[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);

    }
}
