package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class L1160CountCharacters {
    /**
     * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
     *
     * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
     *
     * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
     *
     * 返回词汇表 words 中你掌握的所有单词的 长度之和。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *  思路：
     *     思路就是统计字母表中每个字符出现的次数（用数组存放且将索引缩小到26）
     *     然后再统计每个单词中字符出现的次数，判断是否与包含与被包含的关系
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        if (words == null || words.length == 0
        || chars == null || chars.length() == 0) {
            return 0;
        }
        int ans = 0;

        //统计字母表字符出现的次数
        int[] charss = counterCharsChar(chars);
        for (String word : words) {
            if (contain(counterWordsChar(word), charss)) {
                ans += word.length();
            }
        }
        return ans;
    }

    /**
     * 判断每个单词是否满足条件按
     * @param word
     * @param chars
     * @return
     */
    public boolean contain(int[] word, int[] chars) {
        for (int i = 0; i < 26; i++) {
            if (word[i] > chars[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计每个单词中字符出现的次数
     * @param word
     * @return
     */
    public int[] counterWordsChar(String word) {
        int[] arr = new int[26];
        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }
        return arr;
    }

    /**
     * 统计字母表中每个字符出现的次数
     * @param chars
     * @return
     */
    public int[] counterCharsChar(String chars) {
        int[] arr = new int[26];
        for (char ch : chars.toCharArray()) {
            arr[ch - 'a']++;
        }
        return arr;
    }

}
