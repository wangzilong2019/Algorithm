package lanqiao.algorithm.string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        //首先按照字符串长度排序
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        //获取最短长度的字符串
        String minStr = arr[0];
        for (int i = 0; i < minStr.length(); i++) {
            //第i个字符
            char ch = minStr.charAt(i);
            boolean flag = true;
            //
            for (int j = 1; j < arr.length; j++) {
                if (ch  != arr[j].charAt(i)) {
                    flag = false;
                }
            }
            if (flag) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
