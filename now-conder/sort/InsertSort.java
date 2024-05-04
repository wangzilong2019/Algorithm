package sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 6};
        sort(arr);
        for (Integer num: arr) {
            System.out.println(num);
        }
    }

    private static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int curValue = arr[i];
            int idx = i - 1;
            while (idx >= 0 && arr[idx] > curValue) {
                arr[idx + 1] = arr[idx];
                idx--;
            }
            arr[idx + 1] = curValue;

        }
        return arr;
    }
}
