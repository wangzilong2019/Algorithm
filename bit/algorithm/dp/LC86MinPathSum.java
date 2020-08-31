package bit.algorithm.dp;

public class LC86MinPathSum {
    /**
     *     *   问题与上述相同，找到最短路径
     *      *   dp[i][j] = min (dp[i-1][j], dp[i][j-1]) + ar[i][j]
     *      *   初始化第一行和第一列
     * @param grid int整型二维数组
     * @return int整型
     */
    public int minPathSum (int[][] grid) {
        // write code here
        if (grid == null ) {
            return -1;
        }
        //创建一个二维数组
        int[][] pathNums = new int[grid.length][grid[0].length];
        //初始化
        pathNums[0][0] = grid[0][0];
        //初始化第一行和第一列
        for (int j = 1; j < grid[0].length; j++) {
            pathNums[0][j] = pathNums[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            pathNums[i][0] = pathNums[i-1][0] + grid[i][0];
        }

        //动态规划
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                pathNums[i][j] = Math.min(pathNums[i-1][j], pathNums[i][j-1]) + grid[i][j];
            }
        }
        return pathNums[grid.length-1][grid[0].length-1];

    }
}
