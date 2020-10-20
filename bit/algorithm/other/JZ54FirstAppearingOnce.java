package bit.algorithm.other;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class JZ54FirstAppearingOnce {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
    public void Insert(char ch)
    {
        if (map.containsKey(ch)) {
            map.put(ch, -1);
        } else {
            map.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return '#';
    }

    /**
     * 方法二：采用队列加上map集合
     *    队列中仅仅存放每个字符
     *    map记录每个字符出现的次数
     * @param ch
     */
    Queue<Character> queue = new LinkedList<>();
    int[] mp = new int[129];
    public void Insert2(char ch)
    {
        if (!queue.contains(ch)) {
            queue.offer(ch);
        }
        mp[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce2()
    {
        while (!queue.isEmpty()) {
            //弹出队首元素判断是否只出现一次
            char node = queue.poll();
            if (mp[node] == 1) {
                return node;
            }
        }
        return '#';
    }
}
