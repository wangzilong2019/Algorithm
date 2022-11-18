package com.carl.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    /**
     * 弹出元素是判断当前要弹出的元素是否等于队列出口的元素，如果相等则弹出
     * @param val
     */
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    /**
     * 添加元素时，如果要添加的元素大于入口处的元素，就将入口处元素弹出
     * 保证队列单调递减
     * @param val
     */
    void add(int val) {
        while (!deque.isEmpty() && val > deque.peekLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    /**
     * 队顶元素返回最大值
     */
    int peek() {
        return deque.peek();
    }
}
