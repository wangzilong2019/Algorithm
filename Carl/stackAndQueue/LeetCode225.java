package com.carl.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目连接：https://leetcode.cn/problems/implement-stack-using-queues/
 * 思路：只需要一个队列即可模拟栈操作
 *      1、入栈时直接入队即可
 *      2、出栈时要将除队尾元素的所有元素出队然后再入队，此时队首元素即为要出栈的元素，直接出队即可
 */
public class LeetCode225 {

    Deque<Integer> queue;
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /**
     * 入栈直接入队
     * @param x
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * 出栈时要将除队尾元素的所有元素出队然后再入队，此时队首元素即为要出栈的元素，直接出队即可
     * @return
     */
    public int pop() {
        //记录当前队列元素个数
        int size = queue.size();
        //将除队尾元素出队然后入队
        while (size-- > 1) {
            queue.addLast(queue.poll());
        }
        //当前队首元素出队即为要出栈的元素
        return queue.poll();
    }

    /**
     * 读取栈头元素与出栈思路一样
     * @return
     */
    public int top() {
        return queue.peekLast();
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
