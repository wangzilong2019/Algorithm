package lanqiao.algorithm.dp;

import java.util.Scanner;

public class SquareNumber {

    /**
     *   动态规划：
     *       使用多线程思想，同时遍历dp[r1][c1][r2][c2]表示俩者在俩个坐标时的最优值
     *       注意当俩个点在同一处时只需要加一次即可，因为加完一次会变0
     *
     * */
    public static void main(String[] args) {
        //创建一个矩阵存放原始数据
        int[][] map = new int[11][11];
        //创建一个矩阵存放结果
        int[][][][] dp = new int[11][11][11][11];
        //创建输入流对象
        Scanner in = new Scanner(System.in);
        //输入矩阵阶数
        int n = in.nextInt();
        //数组矩阵中元素值
        while (true) {
            int r = in.nextInt();
            int c = in.nextInt();
            int e = in.nextInt();
            //判断是否输入结束
            if (r == 0 && c == 0 && e == 0) {
                break;
            }
            map[r][c] = e;
        }

        //使用多线程思想
        for (int r1 = 1; r1 <= n; r1++) {
            for (int c1 = 1; c1 <= n; c1++) {
                for (int r2 = 1; r2 <= n; r2++) {
                    for (int c2 = 1; c2 <= n; c2++) {
                        //此时俩个点共有四种情况，加上在每个点2种情况下的最大值
                        dp[r1][c1][r2][c2] = Math.max(Math.max(dp[r1-1][c1][r2-1][c2], dp[r1-1][c1][r2][c2-1]),
                                Math.max(dp[r1][c1-1][r2][c2-1], dp[r1][c1-1][r2-1][c2]));
                        dp[r1][c1][r2][c2] += map[r1][c1];
                        //判断俩个点是否在同一处
                        if (r1 != r2 && c1 != c2) {
                            dp[r1][c1][r2][c2] += map[r2][c2];
                        }
                    }
                }
            }
        }

        System.out.println(dp[n][n][n][n]);
    }
}
