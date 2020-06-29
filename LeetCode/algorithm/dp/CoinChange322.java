package leetcode.algorithm.dp;

import java.util.*;

public class CoinChange322 {
    /**

     使用动态规划的思想
     每次当钱数为i时判断当前次数最少还是用当前硬币最少
          f[i] = min(f[i-ci]) + 1

     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //创建一个数组，记录当前总钱数为i的最少次数
        int[] dp = new int[max];
        //填充数组
        Arrays.fill(dp, max);
        dp[0] = 0;
        //动态规划求解
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //判断当前硬币是否可以使用
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
