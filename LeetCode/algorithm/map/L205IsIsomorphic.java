package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class L205IsIsomorphic {
    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/isomorphic-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 输入: s = "egg", t = "add"
     * 输出: true
     * 输入: s = "foo", t = "bar"
     * 输出: false
     */

    /**
     * 因为是同构的，索引要正反
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        //方式一
        //return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
        //方式二
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
   }

    /**
     *  思路：
     *     因为map集合键值对是有序的，因此只需要统计每个字符出现的次数
     *     可以对应map将s和t串对应索引字符键值对映射
     *       假设从 s 映射到 t
     *         判断对应索引的字符 map[c1] = t1 是否存在
     *         不存在则加入map集合中，存在则判断c1键对应的值是否为t1
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphicHelper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            //判断此键在map集合中是否存在映射
            if (map.containsKey(key)) {
                //存在则判断此映射是否为value
                if (map.get(key) != value) {
                    return false;
                }
            } else {
                map.put(key, value);
            }
        }
        return true;
    }

    /**
     * 解法二：
     *    把俩个字符串分别翻译为第三种类型
     *    可以定义一个count映射给出现的字母，然后自增
     * @param s
     * @return
     */
    public String isIsomorphicHelper(String s) {
        //定义一个数组来存放字符的映射
        int[] map = new int[26];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //判断此字符是否出现过
            //相当于给在字符串中第一次出现的字符一个标记且相同字符标记相同
            if (map[ch] == 0) {
                map[ch] = count;
                count++;
            }
            sb.append(map[ch]);
        }
        return sb.toString();
    }

    /**
     * 其实我们不需要将字符串完全转换，我们可以用两个 map 分别记录两个字符串每个字母的映射。将所有字母初始都映射到 0。记录过程中，如果发现了当前映射不一致，就可以立即返回 false 了。
     *
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/isomorphic-strings/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-42/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
/*    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            //判断当前映射值是否相同
            if (mapS[ch1] != mapT[ch2]) {
                return false;
            } else if (mapS[ch1] == 0){
                //若没被修改过
                mapS[ch1] = i+1;
                mapT[ch2] = i+1;
            }
        }
        return true;
    }*/
}
