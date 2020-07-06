package lanqiao.algorithm.dp;

public class DeleteAndEarn740 {
    /**
     打家劫舍法：
     dp[i] 表示前i的元素点数最大值
     对于第i个元素，有俩种选择，删除和不删除
     当不删除第i个元素时，得到前i-1个元素得到的最优结果，即dp[i] 为dp[i-1] 的值
     当删除第i个元素时，得到的是前i-2个元素得到的最优结果加上第i个元素的值乘i，即dp[i] = dp[i-2] + i*all[i-2];
     这里用一个数组all来记录nums数组中元素出现的次数
     all[i]  表示元素为i出现的次数为all[i];

     */
    public int deleteAndEarn(int[] nums) {
        //判断数组是否有效
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //考虑边界情况，当数组只有一个元素时
        if (nums.length == 1) {
            return nums[0];
        }
        //找出数组元素的最大值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        //创建数组来存放元素出现cishu
        int[] all = new int[max+1];
        for (int e : nums) {
            all[e]++;
        }
        int[] dp = new int[max+1];
        //初始化数组
        dp[0] = all[0]*0;
        dp[1] = all[1]*1;
        dp[2] = Math.max(dp[1], all[2]*2);
        for (int i = 3; i <= max; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + all[i]*i);
        }
        return dp[max];
    }
}
