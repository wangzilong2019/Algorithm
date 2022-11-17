package com.carl.stackAndQueue;

import java.util.Stack;

/**
 * 题目链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 * > 思路：运用对对碰，如果相同的元素放在挨在一起就要消除（栈）
 * >       1、遍历字符串，当栈为空时或是当前元素与栈顶元素不同则入栈
 * >       2、否则出栈
 * >       3、遍历完字符串栈中的元素即为结果
 */
public class LeetCode1047 {
    public String removeDuplicates(String s) {
        //创建一个栈
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //若栈为空或是当前元素与栈顶元素不同入栈
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        String sb = "";
        //因为栈的先进后出特性，反向拼接字符串
        while (!stack.isEmpty()) {
            sb = stack.pop() + sb;
        }
        return sb;
    }

    /**
     * 利用字符串来模拟栈
     * @param s
     * @return
     */
    public String removeDuplicates2(String s) {
        StringBuilder sb = new StringBuilder();
        int index = -1;
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (index == -1 || ch != sb.charAt(index)) {
                sb.append(ch);
                index++;
            } else {
                sb.deleteCharAt(index);
                index--;
            }
        }
        return sb.toString();
    }

    /**
     * 双指针:
     *  可以理解为，慢指针为一个新字符串，快指针遍历原字符串
     * @param s
     * @return
     */
    public String removeDuplicates3(String s) {
        //定义快慢指针
        int low = 0;
        int fast = 0;
        //转化为字符数组
        char[] arr = s.toCharArray();
        while (fast < s.length()) {
            arr[low] = arr[fast];

            //判断是否有相邻元素相同
            if (low >= 1 && arr[low] == arr[low - 1]) {
                //回退一个字符
                low--;
            } else {
                low++;
            }
            fast++;
        }
        return new String(arr, 0, low);
    }
}
