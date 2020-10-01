package leetcode.algorithm.map;

import java.util.*;

public class L884UncommonFromSentences {
    /**
     * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
     *
     * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
     *
     * 返回所有不常用单词的列表。
     *
     * 您可以按任何顺序返回列表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *  思路：
     *     将俩个数组中单词放入map集合中并统计单词出现的次数
     *     找出出现次数为1的即为结果
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        if (A == null || A.length() == 0) {
            return B.split(" ");
        }
        if (B == null || B.length() == 0) {
            return A.split(" ");
        }
        //将单词分割为字符串数组
        String[] arrA = A.split(" ");
        String[] arrB = B.split(" ");

        //创建一个数组存放结果
        String[] ans = new String[A.length() + B.length()];
        int index = 0;
        //创建一个map集合
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arrA.length; i++) {
            int count = map.getOrDefault(arrA[i], 0) + 1;
            map.put(arrA[i], count);
        }
        for (int i = 0; i < arrB.length; i++) {
            int count = map.getOrDefault(arrB[i], 0) + 1;
            map.put(arrB[i], count);
        }
        //统计只出现一次的字符串
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                ans[index++] = key;
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }

}
