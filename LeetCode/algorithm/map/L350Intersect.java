package leetcode.algorithm.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L350Intersect {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     */
    /**
     *  思路一：
     *     采用map集合：
     *      1、首先要判断哪较大的和较小的数组
     *      2、交集元素必为其中较小的解元素
     *      3、对于nums1，键值对分别代表数组和出现次数
     *      4、遍历nums2数组，判断是否在nums1数组中出现，且修改出现次数
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        //首先确定一个nums1数组小，nums2数组大
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        //创建一个数组存放并集
        int[] res = new int[nums1.length];
        //创建一个map集合
        Map<Integer, Integer> map = new HashMap<>();
        //统计每个数字出现的次数
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int index = 0;
        //在第二个数组中查找
        for (int num : nums2) {
            //判断此数字在nums1中出现的次数
            int count = map.getOrDefault(num, 0);
            //判断是否在nums1中出现
            if (count > 0) {
                res[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }


    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);
        }

        //创建一个数组存放
        int[] res = new int[nums1.length];
        //首先对俩个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //定义俩个指针分别指向俩个数组头部
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            //首先判断俩个指针指向的元素是否相同
            if (nums1[i] == nums2[j]) {
                res[index++] = nums1[i];
                //指针后移
                i++;
                j++;
            } else {
                //当俩个指针指向的元素不相等时，比较俩个元素，将较小的那个指针后移一位（因为是升序排序）
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
