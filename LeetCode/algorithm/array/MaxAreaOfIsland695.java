package leetcode.algorithm.array;

public class MaxAreaOfIsland695 {


    /**
     *   深度优先遍历求最大岛屿面积
     *      思路：
     *         遍历所有点，求出每个点所在岛屿的面积，然后求最大值
     *
     * */

    int max = 0;
    //求最大岛屿面积
    public int maxAreaOfIsland(int[][] grid) {
        //遍历每一个点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int res = area(grid, i, j);
                    max = Math.max(res, max);
                }
            }
        }
        return max;
    }

    //深度优先遍历图
    public void dfs(int[][] grid, int r, int c) {
        //判断点是否在图中(先污染后处理)
        if (!inArea(grid, r, c)) {
            return;
        }

        //判断点是否被遍历过
        if (grid[r][c] != 1) {
            return;
        }

        //遍历该点
        grid[r][c] = 2;

        //上、又、下、左遍历
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
    }

    //求岛屿的面积
    public int area(int[][] grid, int r, int c) {
        //首先判断点是否在岛屿内
        if (!inArea(grid, r, c)) {
            return 0;
        }

        //判断是否可拓展为岛屿
        if (grid[r][c] != 1) {
            return 0;
        }

        //此点可拓展欸岛屿做标记
        grid[r][c] = 2;

        //返回岛屿面积
        return 1 +
                area(grid, r - 1, c) +
                area(grid, r, c + 1) +
                area(grid, r + 1, c) +
                area(grid, r, c - 1);
    }

    //判断点是否在岛屿之内
    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
