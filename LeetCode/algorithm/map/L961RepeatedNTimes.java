package leetcode.algorithm.map;

import java.util.Arrays;

public class L961RepeatedNTimes {
    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     *
     * 返回重复了 N 次的那个元素。
     */
    /**
     *  方法一：
     *     首先将数组排序
     *     然后统计每个数字出现的次数，判断是否达到题目要求
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        //将数组排序
        Arrays.sort(A);
        //统计每个相同字符出现的次数
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i-1]) {
                count++;
                if (count == A.length / 2) {
                    return A[i];
                }
            } else {
                count = 1;
            }
        }
        return -1;
    }
}
