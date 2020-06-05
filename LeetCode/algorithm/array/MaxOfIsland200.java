package leetcode.algorithm.array;

public class MaxOfIsland200 {


    /**
     *   深度优先遍历求岛屿数目
     *     思路：
     *       遍历岛屿中的每个点，判断该店是否在岛屿中
     *          若在，总数加1，则拓展，将点所在的岛屿变为海洋
     *     拓展岛屿成为海洋：
     *        深度优先遍历
     *
     *
     * */

    //深度优先遍历岛屿
    public void dfs(char[][] grid, int r, int c) {
        //判断此点是否可以走通
        if(!inArea(grid, r, c)) {
            return;
        }

        //判断此点是否可以走通
        if (grid[r][c] != '1') {
            return;
        }

        //标记
        grid[r][c] = '0';

        //上、又、下、左
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);

    }

    public int numIslands(char[][] grid) {
        //判断参数数组是否为为空
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int max = 0;
        //首先遍历岛屿中每个点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //判断当前点是否在岛屿之中
                if (grid[i][j] == '1') {
                    max++;
                    //将此岛与删除
                    dfs(grid, i, j);
                }
            }
        }

        return max;
    }

    //判断点是否可以走通
    public boolean inArea(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
