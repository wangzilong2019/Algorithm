package bit.algorithm.interest.dp;

public class EditDistance {
    public static void main(String[] args) {
        String str1 = "family";
        String str2 = "frame";
        System.out.println("最小操作次数：" + editDistance(str1, str2));
    }

    private static int  editDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int diff = 0;
                //判断当前字符是否相同
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    diff = 0;
                } else {
                    diff = 1;
                }

                int min = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1);
                min = Math.min(min, dp[i-1][j-1] + diff);
                dp[i][j] = min;
            }
        }
        return dp[str1.length()][str2.length()];
    }

}
