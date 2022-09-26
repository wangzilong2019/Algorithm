package com.carl.array;

import java.util.LinkedList;
import java.util.List;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        //创建一个List集合存放结果
        List<Integer> res = new LinkedList<Integer>();
        //记录矩阵的行列
        int row = matrix.length;
        int col = matrix[0].length;
        //记录行列的最小值一次决定遍历轮数
        int min = Math.min(row, col);
        int loop = 0;
        while (loop++ < (min + 1) / 2) {

        }
    }
}
