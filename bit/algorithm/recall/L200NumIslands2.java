package bit.algorithm.recall;

public class L200NumIslands2 {


    //定义上下左右方向
    int[][] nextP = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * dfs方式二
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int cnt = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] book = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && book[i][j] == 0) {
                    cnt++;
                    dfs(grid, row, col, book, i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int row, int col, int[][] book, int curX, int curY) {
        //首先将此点标记
        book[curX][curY] = 1;
        //四个方向遍历
        for (int i = 0; i < 4; i++) {
            int newX = curX + nextP[i][0];
            int newY = curY + nextP[i][1];

            //判断此点是否到达边界
            if (newX < 0 || newX >= row
            || newY < 0 || newY >= col) {
                continue;
            }

            //判断此点是否要搜索
            if (grid[newX][newY] == '1' && book[newX][newY] == 0) {
                dfs(grid, row, col, book, newX, newY);
            }

        }
    }
}
