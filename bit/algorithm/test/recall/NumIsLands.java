package bit.algorithm.test.recall;

public class NumIsLands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, row, col, i, j);
                }
            }
        }
        return count;
    }

    //定义一个方向数组
    static int[][] nextP = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static void dfs(char[][] grid, int row, int col, int curX, int curY) {
        //走过此点赋初值
        grid[curX][curY] = '0';
        //四个方向遍历
        for (int i = 0; i < 4; i++) {
            int nextX = curX + nextP[i][0];
            int nextY = curY + nextP[i][1];

            //判断下一个位置是否合法
            if (nextX >= row || nextX < 0 || nextY >= col || nextY < 0) {
                continue;
            }
            //合法则继续遍历
            if (grid[nextX][nextY] == '1') {
                dfs(grid, row, col, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        char[][] arr = {{'1', '0', '0', '0', '1'},
                       {'1', '0', '1', '1', '1'},
                       {'1', '0', '0', '0', '1'},
                       {'0', '0', '1', '0', '0'}};
        System.out.println(numIslands(arr));
    }
}
