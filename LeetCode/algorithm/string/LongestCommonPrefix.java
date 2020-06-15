package leetcode.algorithm.string;

import java.util.*;
public class LongestCommonPrefix {
    /**
      横向扫描
     由题意可以知道是求出字符串数组每个字符串的最长公共前缀
     可以转化为求1和2的然后结果和3求前缀，知道最后一个字符串
     注意：在遍历时为遍历完最长前缀为“”则结果为“”

     */
    public String longestCommonPrefix(String[] strs) {
        //判断字符串数组是否有效
        if (strs.length == 0 || strs == null) {
            return "";
        }

        String preFix = strs[0];
        //遍历字符串数组
        for (int i = 1; i < strs.length; i++) {
            //求出当前最长公共前缀
            preFix = longestCommonPrefix(preFix, strs[i]);
            //若结果为“”则直接返回
            if (preFix.length() == 0) {
                return "";
            }
        }
        return preFix;
    }

    /**
     此方法求俩个字符串的最长公共前缀
     */
    public String longestCommonPrefix(String str1, String str2) {
        //求出最小长度
        int len = Math.min(str1.length(), str2.length());
        //求出最长公共前缀索引
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }

        //获取最长公共前缀
        return str1.substring(0, index);
    }


    /**
     纵向扫描
     扫描每个字符串的第i个字符，从0开始知道，出现字符不相同

     */
    public String longestCommonPrefix2(String[] strs) {
        //判断字符串是否有效
        if (strs == null || strs.length == 0) {
            return "";
        }

        String preFix = strs[0];
        //遍历字符
        for (int i = 0; i < preFix.length(); i++) {
            char temp = preFix.charAt(i);
            //遍历字符串
            for (int j = 1; j < strs.length; j++) {
                //判断是否满足条件
                if (i == strs[j].length() || temp != strs[j].charAt(i)) {
                    return preFix.substring(0, i);
                }
            }
        }
        return preFix;
    }

}
