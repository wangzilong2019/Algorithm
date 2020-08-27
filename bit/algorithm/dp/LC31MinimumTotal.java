package bit.algorithm.dp;

import java.util.ArrayList;

public class LC31MinimumTotal {
    /**
     * 给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
     */
    /**
     * 自顶到底解法
     * @param triangle
     * @return
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        //计算三角形的行数
        int row = triangle.size();
        int col = row;

        //创建一个一维数组
        int[] temp = new int[row];
        //初始化一维数组
        for (int i = 0; i < col; i++) {
            temp[i] = triangle.get(row - 1).get(i);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                temp[j] = Math.min(temp[j], temp[j+1]) + triangle.get(i).get(j);
            }
        }
        return temp[0];
    }

    public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        //计算三角形的行数
        int row = triangle.size();
        int col = row;

        //创建一个二维数组
        int[][] temp = new int[row][col];
        //初始化
        temp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                //分三种情况
                if (j == 0) {
                    temp[i][j] = temp[i-1][j] + triangle.get(i).get(j);
                } else if (i == j) {
                    temp[i][j] = temp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    temp[i][j] = Math.min(temp[i-1][j-1], temp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = temp[row - 1][0];
        //找到最小值
        for (int j = 1; j < col; j++) {
            if (min > temp[row - 1][j]) {
                min = temp[row - 1][j];
            }
        }
        return min;
    }
}
