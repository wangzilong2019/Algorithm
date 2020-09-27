package lanqiao.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    /**
     * 计算一个字符串可以构造成回文串的最大长度
     *   分析可知：
     *      回文串有2种形式：一种为偶数，成对出现、另一种为技术、成对出现+单个
     * @param str
     * @return
     */
    public static int longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        Set<Character> set = new HashSet<>();
        int count = 0;
        //将字符串变为字符串数组
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            //判断此字符在set集合种是否出现过
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            } else {
                set.remove(arr[i]);
                count++;
            }
        }

        //由set集合判断长度
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }

    /**
     *  判断一个字符串是否为回文串，只考虑字母和数字字符
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            //判断此字符是否为数字或是字母或什么也不是
            if (!Character.isLetterOrDigit(str.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(str.charAt(end))) {
                end--;
            } else {
                //此时字符为数字或是字母
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
