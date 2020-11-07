package bit.algorithm.interest.dp;

public class I1LCSL {
    /**
     *  求俩个字符串的最长公共子序列
     * @param args
     */
    static String str1 = "ABCADAB";
    static String str2 = "BACDBA";
    public static void main(String[] args) {
        cscl();
        print(str1.length(), str2.length());
        System.out.println();
        System.out.println(dp[str1.length()][str2.length()]);
    }

    static StringBuilder sb = new StringBuilder();
    //dp[i][j] 用来记录str1串前i个字符和str2字符串前j个字符的最大公共子序列长度
    static int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    //用来记录公共子序列中的字符
    static int[][] b = new int[str1.length() + 1][str2.length() + 1];
    public static void cscl() {
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {

                //判单第i和j个字符是否相同
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    b[i][j] = 1;
                } else {
                    //当前俩个字符不相同时则比较当前记录的公共子序列长度大小
                    if (dp[i-1][j] > dp[i][j-1]) {
                        dp[i][j] = dp[i-1][j];
                        b[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i][j-1];
                        b[i][j] = 3;
                    }
                }
            }
        }
    }

    /**
     * 这里注意递归条件
     * @param i
     * @param j
     */
    public static void print(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            print(i- 1, j - 1);
            System.out.print(str1.charAt(i-1));
        } else if (b[i][j] == 2) {
            print(i-1, j);
        } else if (b[i][j] == 3) {
            print(i, j-1);
        }
    }
}
