package leetcode.algorithm.map;

import java.util.IllegalFormatCodePointException;

public class L953IsAlienSorted {
    /**
     *
     * @param words
     * @param order
     * @return
     */
    public static boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return true;
        }

        //创建一个map记录单词顺序
        int[] o = new int[128];
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            o[ch] = i;
        }
        flag : for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i+1];

            //比较相同位置单词序列
            for (int j = 0; j < Math.min(cur.length(), next.length()); j++) {
                if (cur.charAt(j) != next.charAt(j)) {
                    if (o[next.charAt(j)] < o[cur.charAt(j)]) {
                        return false;
                    }
                    continue flag;
                }
            }

            //为什么此判断条件不放在前面，原因很简单，把题目看明白
            //此循环不单是仅仅比较长度，而是有限界条件，当前面字符都相同时，再比较长度为了比较空白字符
   if (cur.length() > next.length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
