package leetcode.algorithm.dp;

public class WaysToChange2 {
    /**
     此题为完全背包问题
     通过公式f[i][j] 前i种硬币组成金额为j的种类数
     f[i][j] = sum(f[i-1][j-k*ci])  k范围0到v/vi
     通过替换得到
     f[i][j] = f[i-1][j] + f[i-1][j-ci];
     将二维数组转换为一维数组
     f[j] = f[j] + f[j-ci];

     */
    public int waysToChange(int n) {
        int MOD = 1000000007;
        //创建数组存放硬币
        int[] coins = {25, 10, 5, 1};
        //创建数组存放面值为i的种类数
        int[] dp = new int[n+1];
        //初始化面值为0有一种
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j-coin]) % MOD;
            }
        }
        return dp[n];
    }
}
