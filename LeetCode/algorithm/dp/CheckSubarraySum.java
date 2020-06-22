package leetcode.algorithm.dp;

import java.util.HashMap;

public class CheckSubarraySum {

    /**
     *    判断是否存在连续子数组的和为k的倍数（连续子数组的长度至少为2）
     *       通过nums[i]  来保存前i项之和
     *       这样i-j子数组之和直接相减即可得到，若不用的话要三重循环
     *
     * */
    public boolean checkSubarraySum(int[] nums, int k) {

        //更新呢nums[i]代表前i项数组之和
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }

        //遍历数组得到子数组[start, end]
        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int sum;
                if (start == 0) {
                    sum = nums[end];
                } else {
                    sum = nums[end] - nums[start - 1];
                }
                //判断是否为k的倍数
                if (sum % k == 0) {
                    return true;
                }
            }
        }

        //不是k的倍数
        return false;
    }

    /**
     本体思路，通过建立一个hashmap
     键来存放sum[i] % k
     值来存放索引i
     假设前i个子数组元素之和为res 即键位res%k
     从i到j的子数组之和为k的倍数
     则j的键为(res + n*k) % k
     若存在键相等，则只需要判断值（存放的键索引）之差是否大于2

     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        //创建一个hashMap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        //初始化
        map.put(0, -1);

        //遍历数组
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //记录当前数组之和
            sum += nums[i];

            //首先取余
            if (k != 0) {
                sum %= k;
            }

            //判断是否此键是否出现过
            if (map.containsKey(sum)) {
                //判断索引值差
                if (i - map.get(sum) >= 1) {
                    return true;
                }
            } else {
                //未出现过，将其加入map中
                map.put(sum, -1);
            }
        }
        return false;
    }
}
