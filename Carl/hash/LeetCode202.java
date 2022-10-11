package com.carl.hash;

import java.util.HashSet;
import java.util.Set;

public class LeetCode202 {

    /**
     * 题目链接：https://leetcode.cn/problems/happy-number/
     */
    /**
     * s思路：这里用set集合来记录已经计算的数字，当重复出现时则表明死循环计算不出结果
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        //创建一个Set集合
        Set<Integer> set = new HashSet<>();
        //当集合中没有此数
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNum(n);
        }
        return n == 1;
    }

    /**
     * 求各位数字的平方和
     * @param n
     * @return
     */
    private int getNum(int n) {
        int sum = 0;
        while (n != 0) {
            int m = n % 10;
            n = n / 10;
            sum += m * m;
        }
        return sum;
    }

}
