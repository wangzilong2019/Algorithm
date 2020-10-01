package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class L771NumJewelsInStones {
    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jewels-and-stones
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0
        || S == null || S.length() == 0) {
            return 0;
        }
        //创建集合记录每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        //统计S石头字符串中每个字符出现的次数
        for (char ch : S.toCharArray()) {
            int count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }
        int ans = 0;
        for (char ch : J.toCharArray()) {
            ans += map.getOrDefault(ch, 0);
        }
        return ans;
    }
}
