package sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 6};
        sort(arr);
        for (Integer num: arr) {
            System.out.println(num);
        }
    }

    private static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //记录最小元素的下标
            int minIndex = i;
            //在未排序中找到最小的元素
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //最小元素放在排好序元素中
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
