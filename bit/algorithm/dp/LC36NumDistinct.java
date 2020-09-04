package bit.algorithm.dp;

public class LC36NumDistinct {
    /**
     * 给定两个字符串S和T，返回S子序列等于T的不同子序列个数有多少个？
     * 字符串的子序列是由原来的字符串删除一些字符（也可以不删除）在不改变相对位置的情况下的剩余字符（例如，"ACE"is a subsequence of"ABCDE"但是"AEC"不是）
     * 例如：
     * S ="rabbbit", T ="rabbit"
     */
    /**
     * 动态规划：
     *    f[i][j] 表示前S串中前i个字符和T串中前j个字符相同子序列的个数
     *    s[i] 与 t[j] 有俩种情况
     *    当 s[i] == t[j] 时
     *       第i个字符可用也可以不用
     *       f[i][j] = f[i-1][j-1] + f[i-1][j]
     *    当不相同时
     *       f[i][j] = f[i-1][j]
     *
     *     初始化：
     *        f[i][0] = 1
     *        f[0][j] = 0 (j != 0)
   * @param S string字符串
     * @param T string字符串
     * @return int整型
     */
    public int numDistinct (String S, String T) {
        // write code here
        int row = S.length();
        int col = T.length();
        //创建一个二维数组
        int[][] numD = new int[row+1][col+1];
        //初始化
        numD[0][0] = 1;
        for (int i = 1; i <= row; i++) {
            numD[i][0] = 1;
            for (int j = 1; j <= col; j++) {
                //判断i与j字符是否相同
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    numD[i][j] = numD[i-1][j-1] + numD[i-1][j];
                } else {
                    numD[i][j] = numD[i-1][j];
                }
            }
        }
        return numD[row][col];
    }

    /**
     * 用一维数组优化
     * @param S
     * @param T
     * @return
     */
    public int numDistinct2 (String S, String T) {
        // write code here
        int row = S.length();
        int col = T.length();
        //创建一个二维数组
        int[] numD = new int[col+1];
        //初始化
        numD[0] = 1;
        for (int i = 1; i <= row; i++) {
            //根据上题因为要用到上一行的数据，所以每次要从后往前更新，若还是从前往后，则是使用当前行的数据
            for (int j = col; j > 0; j--) {
                //判断i与j字符是否相同
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    numD[j] = numD[j-1] + numD[j];
                }
            }
        }
        return numD[col];
    }
}
