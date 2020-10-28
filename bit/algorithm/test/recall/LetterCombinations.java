package bit.algorithm.test.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(combinations("234"));
    }

    static Map<Character, String> hashMap = new HashMap<>();
    public static List<String> combinations(String digits) {
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

        StringBuilder sb = new StringBuilder();
        dfs(digits, res, sb, 0);

        return res;
    }

    public static void dfs(String digits, List<String> res, StringBuilder sb, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String strMap = hashMap.get(digits.charAt(idx));
        for (int i = 0; i < strMap.length(); i++) {
            sb.append(strMap.charAt(i));
            dfs(digits, res, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
