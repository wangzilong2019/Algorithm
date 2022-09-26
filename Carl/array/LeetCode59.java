package com.carl.array;

public class LeetCode59 {
    /**
     * 题目链接：https://leetcode.cn/problems/spiral-matrix-ii/
     */

    /**
     * 思路：模拟，这里主要找到循环不变量，每次选择左闭右开，上闭下开
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        //创建一个二维数组存储元素
        int[][] arr = new int[n][n];
        //定义一个计数器
        int count = 0;
        //定义循环的轮数
        int loop = 0;
        int start = 0;
        int i,j;
        //控制循环的轮数，每轮循环围成一个正方形
        while (start++ < n / 2) {
            //上侧从左到右（左闭右开）
            for (j = loop; j < n - loop - 1; j++) {
                arr[loop][j] = ++count;
            }
            //右侧从上到下
            for (i = loop; i < n - loop - 1; i++) {
                arr[i][n - loop - 1] = ++count;
            }
            //下侧从又到左
            for (; j > loop; j--) {
                arr[n - loop - 1][j] = ++count;
            }
            //左侧从下到上
            for (; i > loop; i--) {
                arr[i][loop] = ++count;
            }
            loop++;
        }
        //补充中间的元素
        if (n % 2 == 1) {
            arr[loop][loop] = ++count;
        }
        return arr;
    }
}
