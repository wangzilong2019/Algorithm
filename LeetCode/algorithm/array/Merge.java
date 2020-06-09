package leetcode.algorithm.array;

import java.util.Arrays;

public class Merge {

    /**
     * 合并俩个有序数组到nums1中，且使nums1有序
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 使用“双指针”，一个指针指向mus1另一个指向nums2，从数组头部开始
     *   首先建立一个nums1副本，用于和hums2比较元素大小
     * */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];

        //创建nums1数组副本
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        //定义俩个指针
        int p1 = 0;
        int p2 = 1;
        int p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }

        //判断数组是否复制完毕
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p, m - p1);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p, n - p2);
        }

    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        //同样是双指针，但是从后向前遍历
        //这里不需要开辟一个数组来存放临时元素
        int p1 = m - 1;
        int p2 = n - 1;
        int p = n + m - 1;

        //从后向前遍历
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        //这里注意当p2对nums2数组遍历完毕之后nums1必然有序
        //但仅仅对nums1数组遍历完毕之后，需要将nums2没有遍历的复制到nums1中
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
