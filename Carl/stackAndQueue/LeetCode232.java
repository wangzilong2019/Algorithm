package com.carl.stackAndQueue;

import java.util.Stack;

/**
 * 题目连接：https://leetcode.cn/problems/implement-queue-using-stacks/
 * 思路：用俩个栈模拟一个队列
 *       1、创建一个队列即为创建一个输入栈和输出栈
 *       2、入队时直接push进输入栈
 *       3、出队时要判断输入栈是否为空：空则直接弹出输出栈元素，不为空则要将输入栈元素全部弹到输入栈，再弹出输出栈元素
 */

public class LeetCode232 {
    //创建输入栈和输出栈
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /**
     * 创建队列即为创建一个输入栈一个输出栈，因为用俩个栈模拟一个队列
     */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    /**
     * 入队操作直接入输入栈即可
     * @param x
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * 出队操作首先要判断输出栈是否为空？
     *   1、不为空则直接弹出输出栈
     *   2、为空则要将输入栈元素全部弹出，再进入输出栈，然后再输出栈
     * @return
     */
    public int pop() {
        //当输入栈为空时
        if (stackIn.isEmpty()) {
            return stackOut.pop();
        } else {
            //输入栈不为空
            //将输入栈元素全部弹出到输出栈中
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.pop();
        }
    }

    public int peek() {
        //当输入栈为空时
        if (stackIn.isEmpty()) {
            return stackOut.peek();
        } else {
            //输入栈不为空
            //将输入栈元素全部弹出到输出栈中
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.peek();
        }
    }

    /**
     * 当俩个队列都为空时栈才为空
     * @return
     */
    public boolean empty() {
        if (stackIn.isEmpty() && stackOut.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
