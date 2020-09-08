package bit.algorithm.recall;

public class L130Solve {
    /**
     *给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     *
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     */

    //定义上下左右方向
    int[][] nextP = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     *  本题思路：
     *     分析可知，被X所围绕的区域一定在图形中
     *     反过来想：从里面看X是围墙，再外面看X同样是围墙
     *     所以可以先从外围出发，在外围中将所有的 O 先改一下，做个标记，这样可以把所有的外围O都改完
     *     然后再遍历整个全图、是O 的则填充，是 A的则换位O
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;
        int[][] book = new int[row][col];

        //第一行、最后一行
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O' && book[0][i] == 0) {
                DFS(board, row, col, book, 0, i);
            }

            if (board[row-1][i] == 'O' && book[row-1][i] == 0) {
                DFS(board, row, col, book, row-1, i);
            }
        }

        //第一列、最后一列
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O' && book[i][0] == 0) {
                DFS(board, row, col, book, i, 0);
            }

            if (board[i][col-1] == 'O' && book[i][col-1] == 0) {
                DFS(board, row, col, book, i, col-1);
            }
        }

        //最后一步遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //判断是哪个字符
                if (board[i][j] == 'O') {
                    //替换
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    //换为原来的 O
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void DFS(char[][] board, int row, int col, int[][] book, int curX, int curY) {
        //当前位置标记
        board[curX][curY] = 'A';
        book[curX][curY] = 1;

        //遍历四个方向
        for (int i = 0; i < 4; i++) {
            int newX = curX + nextP[i][0];
            int newY = curY + nextP[i][1];

            //判断是否越界
            if (newX < 0 || newX >= row
                    || newY < 0 || newY >= col) {
                continue;
            }

            //判断新位置是否为'O'
            if (board[newX][newY] == 'O') {
                DFS(board, row, col, book, newX, newY);
            }
        }
    }
}
