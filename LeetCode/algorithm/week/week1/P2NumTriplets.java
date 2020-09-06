package leetcode.algorithm.week.week1;

import java.sql.SQLOutput;

public class P2NumTriplets {
    public static int numTriplets(int[] nums1, int[] nums2) {
        if ( nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return -1;
        }

        int cnt = 0;
        //统计满足类型一的个数
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length - 1; j++) {
                for (int k = j+1; k < nums2.length; k++) {
                    //判断是否满足条件
                    if ((long)nums1[i] * nums1[i] == (long) nums2[j] * nums2[k]) {
                        cnt++;
                    }
                }
            }
        }

        //统计满足类型二的个数
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length - 1; j++) {
                for (int k = j+1; k < nums1.length; k++) {
                    //判断是否满足条件
                    if ((long)nums2[i] * nums2[i] == (long) nums1[j] * nums1[k]) {
                        System.out.println(nums2[i] * nums2[i]);
                        System.out.println(nums1[j] * nums1[k]);
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }
}
