package leetcode.algorithm.string;

import java.util.*;

public class GroupAnagrams1002 {

    /**
     *   本体我的理解：
     *      将字符串排序后以键值对的方式存入map集合中，值得大小代表键字符组成的字符串在在结果集合中的哪个集合
     *       本体需要注意修改结果集合中元素集合的方式
     * */
    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams1002().groupAnagrams(s));
        //System.out.println(new GroupAnagrams1002().sort("dgozap"));
    }

    public List<List<String>> groupAnagrams(String[] str) {
        //创建集合存放结果
        List<List<String>> res = new ArrayList<>();

        if (str == null || str.length == 0) {
            return res;
        }

        //创建map记录每个字符串在res中的哪里集合中
        Map<String, Integer> map = new HashMap<>();
        List<String> newList;
        //遍历每个字符串
        for (int i = 0; i < str.length; i++) {
            //首先将字符串排序
            String temp = sort(str[i]);

            //判断字符串是否有在结果集合中是否有同组合字符的字符串
            if (map.get(temp) == null) {
                //在结果集合中新建立一个集合存放新组合的字符串
                List<String> list = new ArrayList<>();
                list.add(str[i]);
                //在map集合中记录
                map.put(temp, res.size());
                //将新集合加入结果中
                res.add(list);
            } else {
                //当此字符串字符组合在结果集合中已经出现时
                //获取索引
                int index = map.get(temp);
                newList = res.get(index);
                //在原集合中添加元素
                newList.add(str[i]);
            }
        }
        return res;
    }

    //利用桶排序对字符串排序
    public String sort(String str) {
        //创建字符串生成器
        StringBuilder sb = new StringBuilder();
        //求出源字符串长度
        int len = str.length();
        //创建26个桶（因为26个字母q且题目要求都为小写字母）
        byte[] buckets = new byte[26];

        //记录每个字符出现的次数
        for (int i = 0; i < len; i++) {
            buckets[str.charAt(i) - 'a']++;
        }

        //进行桶排序
        for (int i = 0; i < 26; i++) {
            while (buckets[i] > 0) {
                sb.append((char)(i + 'a'));
                buckets[i]--;
            }
        }
        return sb.toString();
    }
}
