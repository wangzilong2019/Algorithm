package bit.algorithm.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L51SolveNQueens {
    /**
     *n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     */
    /**
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        return null;
    }

    public void dfs(List<List<Pair>> allRet, List<Pair> curRet, int curRow, int n) {
        //如果每一行都没有冲突，就是一种可行方案
        if (curRow == n) {
            allRet.add(curRet);
            return;
        }

        //确定当前行的位置是否和已确定皇后的位置冲突
        for (int i = 0; i < n; i++) {
            if (isValidPos(curRet, curRow, i)) {
                curRet.add(new Pair(curRow, i));
                //处理下一行
                dfs(allRet, curRet, curRow + 1, n);
                //回溯
                curRet.remove(curRet.size() - 1);
            }
        }
    }

    public boolean isValidPos(List<Pair> curRet, int row, int col) {
        for (Pair pair : curRet) {
            //判断是否在同一列或是同一斜线
            if (pair.y == col || pair.x + pair.y == row + col || pair.x - pair.y == row - col) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> transResult (List<List<Pair>> allRet, int n) {
        List<List<String>> allMat = new ArrayList<>();
        //所有方案
        for (List<Pair> curRet : allRet) {

        }
        return null;
    }

}
