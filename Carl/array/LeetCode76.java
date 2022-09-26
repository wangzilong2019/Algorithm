package com.carl.array;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        // 合法性校验
        if (s.length() < t.length()) {
            return "";
        }
        Integer min = Integer.MAX_VALUE;
        //定义一个字典记录滑动窗口中所需t的各个元素的个数
        int[] need = new int[128];
        //定义计数器统计所需元素的总个数
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
            cnt++;
        }
        int i = 0;
        int start = 0;
        //滑动窗口进行计算机
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            //判断是否为t串所需要的
            if (need[ch] > 0) {
                //需要该字符
                cnt--;
            }
            //将右边的字符加入窗口
            need[ch]--;
            //判断是否满足
            if (cnt == 0) {
                //调节左面滑动窗口位置
                while (i <= j && need[s.charAt(i)] < 0) {
                    need[s.charAt(i)]++;
                    i++;
                }
                //更新最小的滑动串口大小
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }
                //左边界又移（这里为了下次窗口的调整）
                need[s.charAt(i++)]++;
                cnt++;
            }
        }
        return min == Integer.MAX_VALUE ? "": s.substring(start, start + min);

    }
}
