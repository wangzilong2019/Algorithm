package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class L560SubarraySum {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     *
     * 示例 1 :
     *
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *  方法一：
     *     自我感觉暴力
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //创建一个map集合
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int count = map.getOrDefault(sum, 0) + 1;
            map.put(sum, count);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                count = map.getOrDefault(sum, 0) + 1;
                map.put(sum, count);
            }
        }
        return map.getOrDefault(k, -1);

    }

    /**
     * 方法二：使用map集合优化
     *     pre[i]  记录前i项连续子数组之和
     *    连续子数组之和为k即为 pre[j] - pre[i] = k
     *    即为  pre[j] - k = pre[i]  转化目的为了转换为前i项之和，可以再map集合中查找
     *    即统计有多少个 pre[j] - k 即为统计有多少个  pre[i]
     *    注意初始化
     *
     *    此题的难点就在于一个公式转换问题，明白公式转换问题就不再困惑
     *    目的就是都可以转为前i项之和，可以在map集合中查早
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //创建一个集合
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int ans = 0;
        //初始化（格外注意）
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            //判断是否存在
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            //将前i项之和放入集合中
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
