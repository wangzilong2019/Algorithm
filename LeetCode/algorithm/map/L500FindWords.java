package leetcode.algorithm.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L500FindWords {
    /**
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return words;
        }
        String[] res = new String[words.length];
        int idx = 0;
        //遍历字符串数组
        for (String word : words) {
            //设标记为判断是否此单词满足条件
            boolean flag = true;
            //首先判断第一个字母在哪一行，然后再判断其它字母是否与此在同一行
            int index = getIndex(word.charAt(0));
            //判断其余的字母是否在同一行
            for (int i = 1; i < word.length(); i++) {
                if (getIndex(word.charAt(i)) != index) {
                    flag = false;
                    break;
                }
            }

            //若满足条件
            if (flag) {
                res[idx++] = word;
            }
        }

        return Arrays.copyOfRange(res, 0, idx);
    }


    /**
     * 此种方式设置字符在特定行上的索引
     * @param ch
     * @return
     */
    public int getIndex(char ch) {
        //首先将其转换为小写字母
        char newCh = Character.toLowerCase(ch);
        //在第一行可以找到
        if ("qwertyuiop".indexOf(newCh) != -1) {
            return 1;
            //在第二行找到
        } else if ("asdfghjkl".indexOf(newCh) != -1) {
            return 2;
        } else {
            //在第三行找到
            return 3;
        }
    }
}
