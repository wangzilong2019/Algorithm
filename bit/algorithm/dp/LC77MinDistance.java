package bit.algorithm.dp;

import java.lang.management.ManagementFactory;

public class LC77MinDistance {
    /**
     * 给定两个单词word1和word2，请计算将word1转换为word2至少需要多少步操作。
     * 你可以对一个单词执行以下3种操作：
     * a）在单词中插入一个字符
     * b）删除单词中的一个字符
     * c）替换单词中的一个字符
     */
    /**
     *  动态规划：
     *     俩个字符串右侧由三种对齐方式
     *     第一种
     *     x1, x2, xn
     *     x1, x2
     *     第二种
     *     x1, x2
     *     x1, x2, xn
     *     第一种和第二种只需要删除一个字符，再加上之后的操作次次数即可
     *     第三种
     *     x1, x2
     *     x1, x2
     *     此时第三种由俩种可能，最后一个字符相同或是不同，此时只需要判断俩个字符相同还hi不同，然后再加上之后的即可
     * @param word1 string字符串
     * @param word2 string字符串
     * @return int整型
     */
    public int minDistance (String word1, String word2) {
        // write code here
        //记录俩个字符串的长度
        int row = word1.length();
        int col = word2.length();

        //初始化数组
        int[][] d = new int[row+1][col+1];
        for (int j = 0; j <= col; j++ ) {
            d[0][j] = j;
        }
        for (int i = 0; i <= row; i++) {
            d[i][0] = i;
        }

        //动态规划求解
        int diff;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                //判断当前字符是否相同
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    diff = 0;
                } else {
                    diff = 1;
                }

                //先取俩者最小值
                int temp = Math.min(d[i-1][j] + 1, d[i][j-1] + 1);
                //之后取三者最小值
                d[i][j] = Math.min(temp, d[i-1][j-1] + diff);
            }
        }
        return d[row][col];
    }
}
