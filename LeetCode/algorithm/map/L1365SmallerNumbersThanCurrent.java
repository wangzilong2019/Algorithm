package leetcode.algorithm.map;

public class L1365SmallerNumbersThanCurrent {
    /**
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     *
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     *
     * 以数组形式返回答案。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //创建一个数组
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = counter(nums[i], nums);
        }
        return res;
    }

    /**
     * 统计再数组中比num小的元素个数
     * @param num
     * @param nums
     * @return
     */
    public int counter(int target, int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num < target) {
                count++;
            }
        }
        return count;
    }

    /**
     *  计数排序的思路：
     *    仔细思考
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        //统计各个数字出现的频率
        int[] freq = new int[10];
        for (int num : nums) {
            freq[num]++;
        }

        //对频率进行累加
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i-1];
        }
        //创建一个数组存放结果
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[i] = freq[nums[i] - 1];
            }
        }
        return res;
    }
}
