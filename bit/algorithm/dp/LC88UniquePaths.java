package bit.algorithm.dp;

public class LC88UniquePaths {
    /**
     * 一个机器人在m×n大小的地图的左上角（起点，下图中的标记“start"的位置）。
     * 机器人每次向下或向右移动。机器人要到达地图的右下角。（终点，下图中的标记“Finish"的位置）。
     * 可以有多少种不同的路径从起点走到终点？
     */
    /**
     * 动态规划分析：
     *     每次只能往右、或向下走
     *     dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *     则初始化第一行和第一列
     */
    /**
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        // write code here
        //创建一个二维数组
        int[][] pathNums = new int[m][n];
        //初始化第一行。第一列
        for (int i = 0; i < m; i++) {
            pathNums[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            pathNums[0][j] = 1;
        }
        //使用动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1 ; j < n; j++) {
                pathNums[i][j] = pathNums[i-1][j] + pathNums[i][j-1];
            }
        }
        return pathNums[m-1][n-1];
    }



}
