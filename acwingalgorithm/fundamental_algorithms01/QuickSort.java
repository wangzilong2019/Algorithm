package acwingalgorithm.fundamental_algorithms01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QuickSort {

    static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入待排序元素个数
        int n = in.nextInt();
        //创建数组
        arr = new int[n];
        //输入数组元素
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //快排
        quickSort(arr, 0, n - 1);
        //输入结果
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l];
        //左指针
        int i = l - 1;
        //又指针
        int j = r + 1;
        while (i < j) {
            do {
                i++;
            }while (arr[i] < x);
            do {
                j--;
            }while (arr[j] > x);
            //交换元素
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //这里重新对左区间排序
        quickSort(arr, l, j);
        //这里重新对又区间排序
        quickSort(arr, j + 1, r);
    }
}
