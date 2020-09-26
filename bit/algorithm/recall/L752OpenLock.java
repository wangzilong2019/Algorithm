package bit.algorithm.recall;

import com.sun.jdi.event.StepEvent;
import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L752OpenLock {
    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/open-the-lock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 思路：
     *   采用搜算法
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        //将数据保存到词典中
        Set<String> deadDict = new HashSet<>();
        for (String str : deadends) {
            deadDict.add(str);
        }
        if (deadDict.contains("0000") || deadDict.contains(target)) {
            return -1;
        }

        //创建一个集合记录单词是否被访问过
        Set<String> book = new HashSet<>();
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        //首先将第一个单词入队
        queue.offer("0000");
        //标记已经访问过
        book.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                //队头元素出队
                String curStr = queue.poll();

                //判断是否满足条件
                if (curStr.equals(target)) {
                    return step;
                }

                //不满足条件则搜索
                for (int i = 0; i < curStr.length(); i++) {
                    char ch1 = curStr.charAt(i);
                    char ch2 = curStr.charAt(i);

                    //构造俩个字符串缓冲区
                    StringBuilder sb1 = new StringBuilder(curStr);
                    StringBuilder sb2 = new StringBuilder(curStr);

                    //因为密码有可能加 也有可能减，所以会有俩种可能性，也可能会产生俩个
                    if (ch1 == '9') {
                        ch1 = '0';
                    } else {
                        ch1++;
                    }

                    if (ch2 == '0') {
                        ch2 = '9';
                    } else {
                        ch2--;
                    }

                    //修改字符串
                    sb1.setCharAt(i, ch1);
                    sb2.setCharAt(i, ch2);

                    if (!deadDict.contains(sb1.toString()) && !book.contains(sb1.toString())) {
                        //加入队列
                        queue.offer(sb1.toString());
                        //标记已经访问过
                        book.add(sb1.toString());
                    }

                    if (!deadDict.contains(sb2.toString()) && !book.contains(sb2.toString())) {
                        queue.offer(sb2.toString());
                        book.add(sb2.toString());
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
