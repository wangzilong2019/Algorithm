package com.carl.hash;

public class LeetCode242 {

    /**
     * 题目链接：https://leetcode.cn/problems/valid-anagram/
     */
    /**
     * 思路：创建俩个数组分别记录每个字符出现的次数，然后再分别比较
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //创建俩个数组
        char[] map1 = new char[128];
        char[] map2 = new char[128];
        //记录每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map1[ch1]++;
            map2[ch2]++;
        }
        for (int i = 0; i < 128; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
