package bit.algorithm.other;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JZ31NumberOf1Between1AndN_Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        //创建一个Mapj集合
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //此元素在集合中
            if (map.get(ch) == null) {
                map.put(ch, i);
            } else {
                map.remove(ch);
            }
        }
        List<Integer> list = (List<Integer>) map.values();
        Integer[] arr = (Integer[]) list.toArray();

        return map.size() == 0 ? -1 : ((List<Integer>) map.values()).get(0);
    }
}
