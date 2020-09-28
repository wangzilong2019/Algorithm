package leetcode.algorithm.map;

import java.util.*;

public class L49GroupAnagrams {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //创建一个集合存放结果
        List<List<String>> result = new LinkedList<>();
        //判断输入条件输入满足条件
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        //遍历字符串数组
        for (String str : strs) {
            //对此字符串排序
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            //排序后判断是否在集合种，即判断此组合是否出现过
            //未出现过创建一个集合，若出现过则加入
            String key = new String(arr);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            //第一次出现时上述创建键对应的集合，第二次直接加入
            map.get(key).add(str);
        }
        //这里注意返回值
        return new LinkedList<>(map.values());
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("abd", new LinkedList<>());
        map.get("abd").add("dba");
        map.get("abd").add("dab");

        map.put("cdf", new LinkedList<>());
        map.get("cdf").add("fdc");
        map.get("cdf").add("cfd");

        System.out.println(map.keySet());
        System.out.println(new LinkedList<>(map.values()));
    }
}
