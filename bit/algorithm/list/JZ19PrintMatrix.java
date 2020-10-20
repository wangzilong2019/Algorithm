package bit.algorithm.list;

import java.util.ArrayList;

public class JZ19PrintMatrix {
    /**
     本题采用四个指针标识在上下左右四个位置，之后将遍历的元素加入集合中
      这里需要注意的就是循环判定条件
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int top = 0;
        int bot = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        //创建一个集合保存遍历后的元素
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            //上
            for (int col = left; col <= right; col++) {
                list.add(matrix[top][col]);
            }
            top++;
            //判断是否越界
            if (top < bot) {
                break;
            }
            //右
            for (int row = top; row <= bot; row++) {
                list.add(matrix[row][right]);
            }
            right--;
            //判断是否越界
            if (right < left) {
                break;
            }
            //下
            for (int col = right; col >= left; col--) {
                list.add(matrix[bot][col]);
            }
            bot--;
            if (bot > top) {
                break;
            }
            //左
            for (int row = bot; row >= top; row--) {
                list.add(matrix[row][left]);
            }
            left++;
            //判断是否越界
            if (left > right) {
                break;
            }
        }

        return list;
    }
}
