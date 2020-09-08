package bit.algorithm.recall;

public class L200NumIslands {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     *  遍历整个矩阵，当走到一个岛上时计数器加一且将此岛屿删除
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int cnt = 0;
        //遍历矩阵
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //判断此点是否在岛屿上
                if (grid[i][j] == '1') {
                    cnt++;
                    //将此岛屿删除
                    dfs(grid, i, j);
                }
            }
        }

        return cnt;
    }

    /**
     * 将此点所在的岛屿删除
     * @param gird
     * @param r
     * @param c
     */
    public void dfs(char[][] gird, int r, int c) {
        //首先判断此点是否合法
        if (!isLegal(gird, r, c)) {
            return;
        }

        //判断此点是否可以走通（这里用！1 和 0 有区别）
        if (gird[r][c] != '1') {
            return;
        }

        //标记删除此点
        gird[r][c] = '0';

        //上下左右遍历
        dfs(gird, r-1, c);
        dfs(gird, r+1, c);
        dfs(gird, r, c-1);
        dfs(gird, r, c+1);
    }

    /**
     *  判断此点是否合法
     * @param r
     * @param c
     * @return
     */
    public boolean isLegal(char[][] gird, int r, int c) {
        int row = gird.length;
        int col = gird[0].length;

        if (r < 0 || r >= row
        || c < 0 || c >= col) {
            return false;
        }
        return true;
    }
}
