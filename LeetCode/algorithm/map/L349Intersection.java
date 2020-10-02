package leetcode.algorithm.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L349Intersection {
    /**
     *  求俩个数组额交集：
     *     首先要明确集合的三要素：确定性、无序性、互异性
     *     首先选择一个数组将其元素加入set集合中
     *     然后遍历另一个数组，判断此元素是否在集合中
     *     若在其中则将此元素加入结果数组，且在set集合中删除此元素（因为互异性）
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums1;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums2;
        }
        Set<Integer> set = new HashSet<>();
        //将其中一个数组元素加入集合中
        for (int num : nums1) {
            set.add(num);
        }
        //创建一个数组返回结果
        int len = Math.min(nums1.length, nums2.length);
        int[] res = new int[len];
        int index = 0;
        for (int num : nums2) {
            if (set.contains(num)) {
                res[index++] = num;
                set.remove(num);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
