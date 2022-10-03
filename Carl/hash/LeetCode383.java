package com.carl.hash;

public class LeetCode383 {

    /**
     * 题目链接：https://leetcode.cn/problems/ransom-note/
     */
    /**
     * 思路：创建一个map统计字符出现的频率，在遍历字符串对象判断是否满足要求
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        //合法性判断
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        //创建一个哈希集合
        int[] map = new int[26];
        //遍历字符串
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int temp = --map[ransomNote.charAt(i) - 'a'];
            if (temp < 0) {
                return false;
            }
        }
        return true;
    }
}
