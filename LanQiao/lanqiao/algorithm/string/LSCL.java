package lanqiao.algorithm.string;

public class LSCL {
    static String str1 = "ABCADAB";
    static String str2 = "BACDBA";
    static int[][] flag = new int[str1.length()+1][str2.length()];
    public static void main(String[] args) {
         flag = lcsl(str1, str2);
         print(str1.length(), str2.length());
    }

    public static int[][] lcsl(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1+1][len2+1];
        int[][] flag = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    flag[i][j] = 1;
                } else if (dp[i][j-1] >= dp[i-1][j]) {
                    dp[i][j] = dp[i][j-1];
                    flag[i][j] = 2;
                } else {
                    dp[i][j] = dp[i-1][j];
                    flag[i][j] = 3;
                }
            }
        }
        return flag;
    }

    public static void print(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (flag[i][j] == 1) {
            print(i-1, j-1);
            System.out.print(str1.charAt(i-1));
        } else if (flag[i][j] == 2) {
            print(i, j-1);
        } else {
            print(i-1, j);
        }
    }
}
