package bit.algorithm.arr;

import java.util.Arrays;

public class OddAndEvenSort {
    /**
     * 打印数组元素
     * @param arr
     * @param num
     */
    public void show(int[] arr, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    /**
     * 交互数组元素，使得奇数在前面，偶数在后面（不保证奇数偶数元素的相对顺序）
     * @param arr
     * @param nums
     */
    public void reSort(int[] arr, int nums) {

    }

    /**
     *  奇数移动在前部，偶数在后部，且奇数之间的相对顺序，偶数之间的相对顺序不改变
     *  采用前插法，奇数插在前面
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 1) {
            return;
        }
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            //从前往后，找到一个奇数
            if ((array[i] & 1) == 1) {
                int temp = array[i]; //奇数
                int j = i;
                //i之前的偶数整体后移
                //整体后移的奇数之前就不用后移动了
                while (j > k) {
                    array[j] = array[j-1];
                    j--;
                }
                //因为奇数是按照顺序【排在前的，座椅
                array[k++] = temp;
            }
        }

    }

    /**
     * 采用后插法，将偶数插在后面
     * @param array
     */
    public void reOrderArray2(int [] array) {
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
}
