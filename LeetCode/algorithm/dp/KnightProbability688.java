package lanqiao.algorithm.dp;

import java.util.Scanner;

public class KnightProbability688 {
    /**
     采用动态规划：
     每个点可以从八个点到达，此点的概论等于八个点的概率相加 / 8
     首先创建矩阵初始化开始时在每个点的概率（分析可知非0即1）

     */
    public static double knightProbability(int N, int K, int sr, int sc) {
        //创建一个数组用来存放各个点的概率
        double[][] dp = new double[N][N];
        //创建方向数组
        int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dc = {2, 1, -1, -2, -2, -1, 1, 2};
        dp[sr][sc] = 1;
        //走8步，可以转换为每个点走8遍
        for (; K > 0; K--) {
            //创建一个数组存放临时概率
            double[][] dp2 = new double[N][N];
            //遍历每个点
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c ++) {
                    //每个点遍历8个方向
                    for (int i = 0; i < 8; i++) {
                        int cr = r + dr[i];
                        int cc = c + dc[i];
                        //判断此点是否越界
                        if (cc >= 0 && cc < N && cr >= 0 && cr < N) {
                            //计算此点的概率
                            dp2[cr][cc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }

        //计算每个点个概率和
        double ans = 0;
        for (double[] row : dp) {
            for (double e : row) {
                ans += e;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int sr = in.nextInt();
        int sc = in.nextInt();

        System.out.println(knightProbability(N, K, sr, sc));
    }
}
