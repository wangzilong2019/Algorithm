package com.carl.stackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 题目链接：https://leetcode.cn/problems/top-k-frequent-elements/
 * 思路：优先级队列
 *      1、创建一个优先级队列（小顶堆）
 *      2、创建map统计每个数字出现频率
 *      3、遍历（num,count）对象维持小顶堆元素为k个即为结果
 */
public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        //创建map统计每个整数出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //创建优先级队列（小顶堆）
        PriorityQueue<int[]> queue = new PriorityQueue<>((pair1, pair2)-> pair1[1] - pair2[1]);
        //创建容量为k的小根堆
        for (int num : nums) {
            //当堆中元素个数小于k时
            if (queue.size() < k) {
                queue.add(new int[]{num, map.get(num)});
            } else {
                //当前元素出现的次数大于堆顶元素时处理
                if (map.get(num) > queue.peek()[1]) {
                    //大于等于k个则堆顶元素出队再加入
                    queue.poll();
                    queue.add(new int[]{num, map.get(num)});
                }

            }
        }
        //创建数组存放结果
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

    /**
     * 思路：大顶堆
     *       1、创建一个大顶堆
     *       2、将键值对添加到大顶堆中
     *       3、取出前k个频率高的元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        //创建map统计每个整数出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //创建优先级队列（大顶堆）
        PriorityQueue<int[]> queue = new PriorityQueue<>((pair1, pair2)-> pair2[1] - pair1[1]);
        //将键值对加入大顶堆中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        //取出出现次数最大的前k个数字
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
