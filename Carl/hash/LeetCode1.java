package com.carl.hash;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

    /**
     * 题目链接：https://leetcode.cn/problems/two-sum/
     */

    /**
     * 思路：采用map集合，键存放数组元素，值存放数组元素下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //创建一个结果集合
        int[] res = new int[2];
        //创建一个Map
        Map<Integer, Integer> map = new HashMap<>();
        //遍历数组将元素加入集合中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //再次遍历数组，判断此元素所需要的元素是否在map集合中
        for (int i = 0; i < nums.length; i++) {
            int m = target - nums[i];
            if (map.containsKey(m) && map.get(m) != i) {
                res[0] = i;
                res[1] = map.get(m);
            }
        }
        return res;
    }
}
