package com.carl.stackAndQueue;

import java.util.Stack;

/**
 * 题目链接：https://leetcode.cn/problems/valid-parentheses/
 * > 思路：运用入栈出栈操作（注意当字符串遍历完成且栈为空才匹配成功）
 * >      1、当遇到左括号的时，则入栈相应地右括号
 * >      2、否则当当前栈不为空且字符串没遍历完成或是字符串没遍历完当前字符不等栈顶字符则匹配不成功
 * >      3、否则出栈
 * >      4、遍历完成后当栈为空返回true，否则false
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        //创建一个栈
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
