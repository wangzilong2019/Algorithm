package bit.algorithm.greed;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //找到每次遍历的最小元素的索引，并交换元素
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6};
        selectSort(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
