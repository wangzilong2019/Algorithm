package bit.algorithm.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17LetterCombinations {

    //创建一个集合
    Map<Character, String> hashMap = new HashMap<>();

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字
     */
    /**
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        //在集合中存储键值对
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");

        dfs(digits, res, "", 0);
        return res;
    }

    public void dfs(String digits, List<String> res, String curStr, int digitIdx) {
        if (digitIdx == digits.length()) {
            res.add(curStr);
            return;
        }

        //获取数字对应的字符映射
        String strMap = hashMap.get(digits.charAt(digitIdx));

        for (int i = 0; i < strMap.length(); i++) {
            dfs(digits, res, curStr + digits.charAt(i), digitIdx+1);
        }
    }
}
