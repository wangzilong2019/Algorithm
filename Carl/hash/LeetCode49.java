package com.carl.hash;

import java.util.*;

public class LeetCode49 {

    /**
     * 思路：遍历字符串数组，对每个字符串排序，排序好的字符串作为键，满足要求的字符串作为值
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //创建一个map集合
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        //遍历字符串数组
        for (String str: strs) {
            char[] arr = str.toCharArray();
            //对字符数组排序
            Arrays.sort(arr);
            String sb = new String(arr);
            List<String> list = map.getOrDefault(sb, new ArrayList<String>());
            list.add(str);
            map.put(sb, list);
        }
        //深拷贝结果
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * 思路二，不采用排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        //创建一个map集合
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        //遍历字符串数组
        for (String str: strs) {
            //统计每个字符出现的频率
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            //遍历字符串
            for (int i = 0; i < counts.length; i++) {
                //当出现此字符时
                if (counts[i] > 0) {
                    sb.append((char)(counts[i] + 'a'));
                    sb.append(counts[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<String>());
            list.add(str);
            map.put(sb.toString(), list);
        }
        //深拷贝结果
        return new ArrayList<List<String>>(map.values());
    }

}
