package leetcode.algorithm.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class L697FindShortestSubArray {
    /**
     *  思路：
     *     使用map集合
     *       1、创建三个map集合left，right和count
     *       1、left集合键值对键为元素，值为此元素再数组中i第一次出现的位置
     *       1、right集合键值对，键为存储的集合元素，值为此元素最后一次再数组中出现的位置
     *       1、count集合，键值对，键位此元素，此元素在集合中出现的次数
     *
     *     之后找出最大度，然后再找出最小的连续子数组
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //创建三个集合
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //记录此元素第一次出现的位置
            if (left.get(nums[i]) == null) {
                left.put(nums[i], i);
            }
            //记录此元素最后一次出现的位置
            right.put(nums[i], i);
            //统计此元素出现的次数
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        //记录最大度
        int ans = nums.length;
        int max = Collections.max(count.values());
        for (int key : count.keySet()) {
            int value = count.get(key);
            if (value == max) {
                ans = Math.min(ans, right.get(key) - left.get(key) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
