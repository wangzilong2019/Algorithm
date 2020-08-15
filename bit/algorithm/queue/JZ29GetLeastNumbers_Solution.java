package bit.algorithm.queue;

import java.util.*;

public class JZ29GetLeastNumbers_Solution {
    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     */
    /**
     * 此种方式是去通过构建指定大小的优先队列，然后对队列中元素排序，遍历集合中的元素与队列头元素比较
     * 优先队列其实就是一个指定大小的最大堆
     * 从而找到最小元素的四个值
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) {
            return list;
        }
        //创建一个优先级队列
        /**
         * 因为要找到元素较小的4个值，所以要构建4个元素的大根堆，比较子元素与队头元素从而找到最小的自身个元素
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());  //其实就是构建最大堆
        for (int i = 0; i < input.length; i++) {
            //当队列中元素小于等于k个时
            if (i < k) {
                queue.offer(input[i]);
            } else {
                //判断此元素与队头元素的大小
                if (input[i] < queue.peek()) {
                    //队头元素出队
                    queue.poll();
                    //小元素入队
                    queue.offer(input[i]);
                }
            }
        }
        //将队列元素放入集合
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    /**
     *  方式二：排序去取前k个值
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) {
            return list;
        }
        //排序
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
}
