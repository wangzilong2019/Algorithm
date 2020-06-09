package lanqiao.algorithm;

import java.util.*;

public class StatisticsMostInt {


    //public class Main {
        public static void main (String[] args) {
            //创建输入流对象
            Scanner in = new Scanner(System.in);
            //输入数组中元素个数
            int n = in.nextInt();
            //创建数组对象
            int[] arr = new int[n];
            //输入数组中元素
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            //记录出现最多的元素
            int most_ele = 0;
            //记录元素出现次数
            int most_exp = 0;
            int exp = 1;
            //遍历元素
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] == arr[i+1]) {
                    exp++;
                } else if (exp > most_exp) {
                    most_exp = exp;
                    most_ele = arr[i];
                    exp = 1;
                } else if (exp == most_exp && arr[i] < most_ele) {
                    most_ele = arr[i];
                    exp = 1;
                }
            }

            System.out.println(most_ele);
        }
   // }

}
