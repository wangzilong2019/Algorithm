package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 6};
        sort(arr);
        for (Integer num: arr) {
            System.out.println(num);
        }
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }
}
