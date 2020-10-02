package leetcode.algorithm.map;

import java.util.Arrays;

public class L1331ArrayRankTransform {
    /**
     *
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //找到最小值和最大值
        for (int num : arr) {
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }
        //创建一个数组
        int[] count = new int[max - min + 1];
        //第一次遍历记录存在数字
        for (int num : arr) {
            count[num - min] = 1;
        }
        //第二次遍历对数字排序（仔细思考）
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i-1] + count[i];
        }
        //创建一个结果数组存放索引
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = count[arr[i] - min];
        }
        return res;
    }


}
