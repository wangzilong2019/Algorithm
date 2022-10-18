package com.carl.hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //创建结果集
        List<List<Integer>> res = new LinkedList<>();
        //对数组进行排序
        Arrays.sort(nums);
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //第二个指针
            for (int j = i + 1; j < nums.length; j++) {
                if (j > 0 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //定义第三个第四个指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //计算四者之和
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    //判断是否为目标值
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        //满足条件则加入集合
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], right));

                        //剪纸操作
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        //移动指针位置
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
