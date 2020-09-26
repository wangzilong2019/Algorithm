package bit.algorithm.recall;

import java.util.*;

public class L127LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //创建一个队列
        Queue<String> queue = new LinkedList<>();
        //创建俩个集合，记录元素是否被访问过
        Set<String> book = new HashSet<>();
        //创建集合表示是否在其中
        Set<String> dict = new HashSet<>();

        //首先将第一个单词加入队列中
        queue.offer(beginWord);
        book.add(beginWord);

        int step = 1;
        //词典转换
        for (String str : wordList) {
            dict.add(str);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                //队头元素出队
                String curStr = queue.poll();

                //判断此元素是否满足条件
                if (curStr.equals(endWord)) {
                    return step;
                }
                //修改单词中的某一个字符
                for (int i = 0; i < curStr.length(); i++) {
                    char[] strArr = curStr.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        strArr[i] = ch;

                        //判断新的单词是否在词典中，且是否没有搜索过
                        if (dict.contains(new String(strArr)) && !book.contains(new String(strArr))) {
                            queue.offer(new String(strArr));
                            //标记已经使用过
                            book.add(new String(strArr));
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
