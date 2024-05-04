package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 6, 1, 9};
        sort(arr, 0, arr.length - 1);
        for (Integer num: arr) {
            System.out.println(num);
        }
    }

    public static void sort(int[] arr, int left, int right) {
        int temp, i, j, t;
        if (left > right) {
            return;
        }
        i = left;
        j = right;
        //选择基准位
        temp = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= temp) {
                j--;
            }
            //左边找比基准位置大的数字
            while (i < j && arr[i] <= temp) {
                i++;
            }

            //交换
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //基准位置和交界处交换
        arr[left] = arr[i];
        arr[i] = temp;
        sort(arr, left, j - 1);
        sort(arr, j + 1, right);
    }
}
