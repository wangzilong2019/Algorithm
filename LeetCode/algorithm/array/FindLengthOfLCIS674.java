package leetcode.algorithm.array;

public class FindLengthOfLCIS674 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(new FindLengthOfLCIS674().findLengthOfLCIS(nums));
    }

    /**
     *   动态规划思想：
     *    从后向前遍历，若当前数字小于下一个数字时当前开始地最长升序子序列长度 = 下一个元素开始地最长升序子序列长度+1
     *    否则生成一个升序子序列长度 与最长作比较
     *
     * */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLen = 0;
        int len = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            //判断当前数字与后一个的大小
            if (nums[i] <= nums[i+1]) {
                len++;
            } else {
                //当出现一个升序列长度和最长的作比较
                if (len > maxLen) {
                    maxLen = len;
                }
                len = 1;
            }
            //第一个元素开始的升序列长度与作比较
            if (i == 0 && len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }

    /**
     *  空间内存优化
     *
     * */
    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] len = new int[nums.length];
        int maxLen = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            //判断当前数字与后一个的大小
            if (nums[i] < nums[i+1]) {
                len[i] = len[i+1] + 1;
            } else {
                //当出现一个升序列长度和最长的作比较
                if (len[i+1] > maxLen) {
                    maxLen = len[i+1];
                }
            }
            //第一个元素开始的升序列长度与作比较
            if (i == 0 && len[i] > maxLen) {
                maxLen = len[i];
            }
        }
        return maxLen + 1;
    }
}
