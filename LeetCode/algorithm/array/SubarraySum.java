package leetcode.algorithm.array;

import java.util.HashMap;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //暴力解法
        //每次将i-j子数组相加
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        /**
         pre[i]  表示以0-i数组元素之和
         设j-i子数组之和为k
         则k = pre[i] - pre[j-1]
         pre[j-1] = pre[i] - k
         求子数组之和为k的个数即求pre[j]的个数
         //创建一个哈希表存储
         */
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        //初始化
        mp.put(0, 1);
        //用pre简化pre数组
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            //判断子元素之和是否等于k
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            //计算新的和放入mp
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
