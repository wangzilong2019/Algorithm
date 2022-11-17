package com.carl.stackAndQueue;

import java.util.Stack;

/**
 * 题目链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * 思路：
 *      遇到数字则入栈；
 *      遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        //创建一个栈
        Stack<Integer> stack = new Stack<>();
        //遍历字符串数组
        for (String str : tokens) {
            //运算符则进行响应的操作
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (str.equals("/")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                //数字则入栈
                stack.push(Integer.valueOf(str));
            }
        }
        //弹出结果
        return stack.pop();
    }
}
