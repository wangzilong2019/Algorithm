package com.carl.stackAndQueue;

/**
 * 题目链接：https://leetcode.cn/problems/sliding-window-maximum/
 * 思路：使用单调队列
 * 有的同学可能会想用一个大顶堆（优先级队列）来存放这个窗口里的k个数字，这样就可以知道最大的最大值是多少了，
 * 但是问题是这个窗口是移动的，而大顶堆每次只能弹出最大值，我们无法移除其他数值，这样就造成大顶堆维护的不是滑动窗口里面的数值了。所以不能用大顶堆
 * 设计单调队列的时候，pop，和push操作要保持如下规则：
 * pop(value)：如果窗口移除的元素value等于单调队列的出口元素，那么队列弹出元素，否则不用任何操作
 * push(value)：如果push的元素value大于入口元素的数值，那么就将队列入口的元素弹出，直到push元素的数值小于等于队列入口元素的数值为止
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        //结算结果元素的大小
        int len = nums.length - k + 1;
        //创建数组存放结果
        int[] res = new int[len];
        int index = 0;
        //创建队列
        MyQueue queue = new MyQueue();
        //将前k个元素加入队列中
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        //首个窗口
        res[index++] = queue.peek();
        //滑动窗口开始移动
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            queue.poll(nums[i - k]);
            //处理当前元素
            queue.add(nums[i]);
            //记录对应的最大值
            res[index++] = queue.peek();
        }
        return res;
    }
}
