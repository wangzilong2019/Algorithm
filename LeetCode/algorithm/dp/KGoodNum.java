package lanqiao.algorithm.dp;

import java.util.Scanner;

public class KGoodNum {
    /**
     *   k好数
     *      使用动态规划来求解
     *      dp[i][j]代表i为数以j开头的k好数的个数
     *   注意：题目要求为l位数字所以以0开头的俩个数字不是俩位数
     *      dp[i][j] = dp[i-1][x]  //标签i位k好数等于i-1位以x开头的k好数（这里话中有问题，具体分析代码）
     *
     * */

    public static void main(String[] args) {
        final int MOD = 1000000007;
        //创建输入流对象
        Scanner in = new Scanner(System.in);
        //输入k额l
        int k = in.nextInt();
        int l = in.nextInt();

        //创建一个数组dp[i][j]表示i位数字j开头的k好数
        int[][] dp = new int[l+1][k];
        //初始化第一行(i开头的即1位k好数位1个)
        for (int i = 0; i < k; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= l; i++) {
            //以j开头的i位数
            for (int j = 0; j < k; j++) {
                //判断添加的一位j再开头与i-1位开头的是否相邻
                for (int x = 0; x < k; x++) {
                    if (x != j+1 && x != j - 1) {
                        dp[i][j] += dp[i -1][x];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        int sum = 0;
        //因为第一行列是0开头，所以不需要加，因为不是l位数
        for (int i = 1; i < k; i++) {
            sum += dp[l][i];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}
