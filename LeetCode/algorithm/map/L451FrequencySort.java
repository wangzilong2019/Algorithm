package leetcode.algorithm.map;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.*;

public class L451FrequencySort {
    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     */
    /**
     *  思路：使用mao加大根堆
     *     1、创建一个map来存放每个字符以及出现的次数
     *     2、创建大根堆maxHeap，保证堆顶char是出现次数最大的
     *     3、创建一个StringBuilder存储结果
     *     4、弹出堆顶、按照其统计次数，建立循环，将char加入结果中，重复上述
     *     5、输出结果
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //创建一个map集合，键值对存放字符以及字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        //统计每个字符出现的次数
        for (char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch, 0) + 1;
            map.put(ch, count);
        }
        //创建一个大根堆
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> t1, Map.Entry<Character, Integer> t2) {
                return t2.getValue() - t1.getValue();
            }
        });

        maxHeap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            //弹出堆顶元素
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            //通过字符出现的次数添加字符的个数
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

    }
}
