package bit.algorithm.arr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class JZ13ReOrderArray {
    /**
     * 这里按顺序放置要想到队列、栈
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        //创建俩个队列
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        //遍历数组奇数放在第一个队列中，偶数放在第二个队列中
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                queue2.offer(array[i]);
            } else {
                queue1.offer(array[i]);
            }
        }
        int idx = 0;
        while (!queue1.isEmpty()) {
            array[idx++] = queue1.poll();
        }
        while (!queue2.isEmpty()) {
            array[idx++] = queue2.poll();
        }
    }

    /**
     * 从后往前找：
     *    思路：遇到偶数元素则把偶数之后的奇数元素整体移动一位，然后将此偶数元素按顺序放在后
     * @param array
     */
    public static void reOrderArray2(int [] array) {
        if (array == null || array.length == 1) {
            return;
        }
        int k = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if ((array[i] & 1) == 0) {
                int temp = array[i]; //奇数
                int j = i;
                //i之前的偶数整体后移
                //整体后移的奇数之前就不用后移动了
                while (j < k) {
                    array[j] = array[j+1];
                    j++;
                }
                //因为奇数是按照顺序【排在前的，座椅
                array[k--] = temp;
            }
        }
    }

    public static void reOrderArray3(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int len = array.length;
        int k = 0;
        for (int i = 0; i< array.length; i++) {
            //找到奇数
            if ((array[i] & 1) == 1) {
                int temp = array[i];
                int j = i;

                while (k < j) {
                    array[j] = array[j-1];
                    j--;
                }
                array[k++] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 6, 1, 3, 5, 8};
        reOrderArray2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
