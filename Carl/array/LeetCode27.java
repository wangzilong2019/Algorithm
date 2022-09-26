package com.carl.array;

public class LeetCode27 {
    /**
     * 题目链接：https://leetcode.cn/problems/remove-element/
     */

    /**
     * 思路一：拷贝覆盖（快慢指针方法）：遍历数组，当遇到与目标值不同的元素依次从前往后覆盖存放
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //定义新数组的索引
        int i = 0;
        for (int num : nums) {
            //当与val不同时则覆盖
            if (num != val) {
                nums[i++] = num;
            }
        }
        return i;
    }

    /**
     * 解法二：双指针解法：根据题意将数组分为2段，前一段是有效部分（元素不为val），后一段是无效部分（元素为val）
     * 这里精髓为swap_num(nums, i--, j--);这里的i--因为要判断后面交换而来的元素是否为val
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        //遍历数组当前半部分元素值为val则与后半部分交换
        while (i < j) {
            if (nums[i] == val) {
                swap_num(nums, i--, j--);
            }
            i++;
        }
        return j + 1;
    }

    private void swap_num(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
