package leetcode.algorithm.map;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

public class L389FindTheDifference {
    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     */
    /**
     *  解法一：
     *    使用异或；你懂的
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res;
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        //创建一个集合
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int count = map.getOrDefault(ch, 0);
            if (count == 0) {
                return ch;
            } else {
                map.put(ch, --count);
            }
        }
        return '0';
    }
}
