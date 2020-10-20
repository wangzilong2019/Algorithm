package bit.algorithm.other;

import java.util.Scanner;

public class FindIncreaseSub {
    /**
     *  判断一个无序数组中是否存在长度为3的递增子序列（不要求连续），满足O(1)空间复杂度和O(n)时间复杂度
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入数字的个数
        int n = in.nextInt();
        //创建数组存放输入的数据
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        boolean flag = false;
        int first = arr[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[i] < first) {
                first = arr[i];
                second = Integer.MAX_VALUE;
            } else if (arr[i] > first && arr[i] < second) {
                second = arr[i];

            } else if (arr[i] > first && arr[i] > second) {
                flag = true;
                System.out.println(true);
                break;  //这里跳出循环因为可能找到多个
            }
        }
        if (!flag) {
            System.out.println(false);
        }
    }
}
