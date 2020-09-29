package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class L260SingleNumber {
    /**
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
     * 找出只出现一次的那两个元素。
     */
    /**
     * 方法一：
     *     使用map集合键值对分别代表数字以及出现的次数
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //创建一个数组
        int[] arr = new int[2];
        int index = 0;
        //统计各个数字出现的次数
        for (int i = 0; i < nums.length; i++) {
            //判断此数字是否出现过
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
            }
        }

        //统计只出现一次的数字
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                arr[index++] = nums[i];
            }
        }
        return arr;
    }

    /**
     *  方法二：
     *     采用异或，当俩个相同的数字异或结果一定为0
     *     异或结果一定为俩个单次出现的次数的数字异或结果
     *     之后分离：分离真的我也没明白
     * @param nums
     * @return
     */
    public int[] singleNumber2(int[] nums) {
        int bitMask = 0;
        for (int i = 0; i < nums.length; i++) {
            bitMask ^= nums[i];
        }

        //最后一个1一定为俩个数字的一个
        //找到最后一个1且其余1置零
        int diff = bitMask & (-bitMask);
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }
        return new int[]{x, x ^ bitMask};
    }

}
