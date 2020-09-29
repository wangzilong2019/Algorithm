package leetcode.algorithm.map;

import javax.sql.rowset.spi.SyncResolver;
import java.util.HashMap;
import java.util.Map;

public class L290WordPattern {
    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     */
    /**
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        return wordPatternHelper(pattern).equals(wordPatternHelper2(s));
    }

    /**
     * 创建一个字符串的映射关系
     * @param s
     * @return
     */
    public String wordPatternHelper(String s) {
        StringBuilder sb = new StringBuilder();
        //存放每个字符的映射关系
        int[] map = new int[128];
        //为每个字符标号
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //判断此字符是否出现过
            if (map[ch] == 0) {
                //第一次出现
                map[ch] = count++;
            }
            sb.append(map[ch]);
        }
        return sb.toString();
    }

    /**
     * 适用于字符串
     * @param s
     * @return
     */
    public String wordPatternHelper2(String s) {
        StringBuilder sb = new StringBuilder();
        //存放每个字符的映射关系
        Map<String, Integer> map = new HashMap<>();
        //将字符串分割为字符串数组
        String[] arr = s.split("\\s");

        //为每个字符标号
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            //判断此字符串是否第一次出现
            if (map.get(str) == null) {
                map.put(str, count++);
            }
            sb.append(map.get(str));
        }
        return sb.toString();
    }


    /**
     *   方法二：直接pattern映射到string
     * @param s
     * @param t
     * @return
     */
    public boolean wordPattern2(String pattern, String s) {
        //将字符串分割为字符串数组
        String[] arr = s.split("\\s");
        if (arr.length != pattern.length()) {
            return false;
        }

        //创建一个map集合映射关系
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            //获取对应的键
            char key = pattern.charAt(i);
            String value = arr[i];
            //判断此键是否出现过
            if (!map.containsKey(key)) {
                //判断此键对应的值是否已使用
                if (map.containsValue(value)) {
                    return false;
                }
                //否则第一次使用放入map集合中
                map.put(key, value);
            } else {
                //出现过判断是否配对
                if (!map.get(key).equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }

}
