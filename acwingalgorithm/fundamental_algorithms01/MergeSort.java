package acwingalgorithm.fundamental_algorithms01;

import java.util.Scanner;

public class MergeSort {
    static int[] arr;
    static int[] temp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入数组元素个数
        int n = in.nextInt();
        //创建数组
        arr = new int[n];
        temp = new int[n];
        //输入数组元素
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //归并排序
        mergeSort(arr, 0, n - 1);
        //输出
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //二分区间
        int mid = (l + r) >> 1;
        //左指针
        int i = l;
        //又指针
        int j = mid + 1;
        //左区间排序
        mergeSort(arr, i, mid);
        //右区间排序
        mergeSort(arr, j, r);
        int k = 0;
        //合并区间
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = temp[j];
        }
    }
}
