package lanqiao.algorithm.string;

public class LongestPalindromeSubseq {
    /**
     * LeetCode: 最长回文子序列 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
     * 最长回文子序列和上一题最长回文子串的区别是，子串是字符串中连续的一个序列，
     * 而子序列是字符串中保持相对位置的字符序列，例如，”bbbb”可以是字符串”bbbab”的子序列但不是子串。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     *  采用动态规划的方法解决：
     *     dp[i][j] 表示索引i，j最长回文子序列长度
     *     如果 s[i] == s[j]  则dp[i][j] = dp[i+1][j-1] + 2
     *     否则 dp[i][j] = max(dp[i+1][j], dp[i][j-1])
     *   因为需要从短 到长满足更新dp的值，索引选择从短到长遍历字符串
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];

        //从后往前遍历字符串，自信思考其实就是为了从短到长遍历字符串
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                //判断i,j俩个字符是否相等
                if (s.charAt(i) == s.charAt(j)) {
                    //这里注意就算i+1 > j-1 也没关系，因为此时为0
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
