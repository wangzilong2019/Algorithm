package leetcode.algorithm.dp;

public class FindMaxForm474 {
    /**
     *   采用动态规划:
     *     dp[i][j]  表示采用i个0和j个1可以拼接处的最大个数
     *      状态转移方程
     *      dp[i][j] = Math.max(dp[i][j], 1+dp[i-zero][j-one])
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        //遍历字符串数组
        for (String str : strs) {
            //统计子字符串0和1的个数
            int[] c = countzeroesones(str);
            //动态规划求结果
            for (int zero = m; zero >= c[0]; zero--) {
                for (int one = n; one >= c[1]; one--) {
                    dp[zero][one] = Math.max(dp[zero][one], 1 + dp[zero - c[0]][one - c[1]]);
                }
            }
        }
        return dp[m][n];
    }

    //求字符串中0和1的个数
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            ++c[s.charAt(i) - '0'];
        }
        return c;
    }
}
