package leetcode.algorithm.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1TwoSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 这里暴力解法就不提了：
     *    采用map集合的方法
     *    首先将数据存储到map集合种，键为元素值，值为下标
     *    之后通过差值判断是否在map集合种，此时时间复杂度为o(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //创建一个数组来存放结果下标
        int[] result = new int[2];
        //创建一个集合
        Map<Integer, Integer> map = new HashMap<>();
        //遍历集合元素
        for (int i = 0; i < nums.length; i++) {
            //计算差值判断差值是否在集合中
            int diff = target - nums[i];
            //判断差值是否在集合中
            //这里不用加索引判断条件，因为此时在后序添加元素到集合种，所以它永远不会用到自己的元素
            if (map.containsKey(diff) ) {
                //将结果放入数组种
                result[0] = i;
                result[1] = map.get(diff);
                //返回结果集
                return result;
            }
            //这里注意一定不能先将元组添加到集合中，若是将元素先添加到集合种，若不加索引判断条件则会用到自己
            map.put(nums[i], i);
        }
        return null;
    }
}
