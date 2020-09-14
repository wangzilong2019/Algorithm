package bit.algorithm.recall;

import java.util.LinkedList;
import java.util.Queue;

public class L994OrangeRotting {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotting-oranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *  本体分析：广度优先搜索
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        //上下左右
        int[][] nextP = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //创建一个队列，首先将腐烂的橘子入队
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //已经腐烂的橘子入队
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int size  = queue.size();
            //用来判断是否有新腐烂的橘子产生
            boolean flag = false;

            while (size-- != 0) {
                //当前队头元素出队
                Pair cur = queue.poll();

                //搜索新的位置
                for (int i = 0; i < 4; i++) {
                    int newX = cur.x + nextP[i][0];
                    int newY = cur.y + nextP[i][1];

                    //判断新的位置是否越界
                    if (newX < 0 || newX >= row
                    || newY < 0 || newY >= col) {
                        continue;
                    }

                    //判断此腐烂的橘子周围是否有新鲜橘子
                    if (grid[newX][newY] == 1) {
                        //产生腐烂的橘子且入队
                        grid[newX][newY] = 2;
                        flag = true;
                        queue.offer(new Pair(newX, newY));
                    }
                }
            }
            if (flag) {
                count++;
            }
        }

        //判断是否还有新鲜橘子
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
