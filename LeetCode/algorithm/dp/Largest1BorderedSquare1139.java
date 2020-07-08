package lanqiao.algorithm.dp;

public class Largest1BorderedSquare1139 {
    /**
     动态规划解题：
     创建四个方向数组up[i][j],right[i][j],down[i][j],left[i][j]
     分别up[i][j]表示以(i, j)点开始向上的最大连续1长度,其它也是如此
     四个方向数组都需要借助grid来构造值
     if (grif[i][j] == 0) {
     up[i][j] = 0;
     } else {
     up[i][j] = up[i-1][j];
     }
     其它也是如此
     通过计算出点(i, j)向下向有的最长连续1长度的最小值
     然后再以此计算出对角点的

     */
    public int largest1BorderedSquare(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        //创建四个方向数组
        int[][] up = new int[row][col];
        int[][] down = new int[row][col];
        int[][] left = new int[row][col];
        int[][] right = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                up[i][j] = grid[i][j];
                right[i][j] = grid[i][j];
                down[i][j] = grid[i][j];
                left[i][j] = grid[i][j];
            }
        }

        for (int i = 1 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //初始化数组元素值
                if (grid[i][j] == 0) {
                    up[i][j] = 0;
                } else {
                    up[i][j] = up[i-1][j] + 1;
                }
            }
        }

        for (int i = row-2 ; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                //初始化数组元素值
                if (grid[i][j] == 0) {
                    down[i][j] = 0;
                } else {
                    down[i][j] = down[i+1][j] + 1;
                }
            }
        }

        for (int j = 1 ; j < col; j++) {
            for (int i = 0; i < row; i++) {
                //初始化数组元素值
                if (grid[i][j] == 0) {
                    left[i][j] = 0;
                } else {
                    left[i][j] = left[i][j-1] + 1;
                }
            }
        }

        for (int j = col-2 ; j >= 0; j--) {
            for (int i = 0; i < row; i++) {
                //初始化数组元素值
                if (grid[i][j] == 0) {
                    right[i][j] = 0;
                } else {
                    right[i][j] = right[i][j+1] + 1;
                }
            }
        }

        int result = 0;

        //遍历栅格
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //计算以此点向下向右的最长连续的长度最小值
                int minOne = Math.max(down[i][j], right[i][j]);

                //从对角点出发
                for (; minOne > 0; minOne--) {
                    //计算从对角点向上向左最长连续长度的最小值
                    int minTwo = Math.max(up[i+minOne-1][j+minOne-1], left[i+minOne-1][j+minOne-1]);
                    //判断minOne是否小于minTwo（即判断是否可以组成一个正方形）
                    if (minOne <= minTwo) {
                        result = Math.max(result, minOne);
                        break;
                    }

                }

                //判断剩余空格是否可以创建正方形
                if (i+result >= row && j+result >= col) {
                    return result*result;
                }
            }
        }
        return 0;
    }
}
