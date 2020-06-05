package leetcode.algorithm.array;

public class IslandPerimeter463 {

    public static void main(String[] args) {

    }

    public int dfs(int[][] grid, int r, int c) {
        //判断点是否在岛屿中表明此点上一个点为边界
        if (!inArea(grid, r, c)) {
            return 1;
        }

        //判断此点是否走过，表明此点上一个点与海洋相连
        if (grid[r][c] != 1) {
            return 1;
        }

        //标记走过
        grid[r][c] = 2;

        return dfs(grid, r - 1, c) +
                dfs(grid, r, c + 1) +
                dfs(grid, r + 1, c) +
                dfs(grid, r, c - 1);
    }

    //判断点是否在岛屿中
    public boolean inArea (int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
