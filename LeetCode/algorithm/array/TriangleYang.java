package leetcode.algorithm.array;

import java.util.LinkedList;
import java.util.List;

public class TriangleYang {
    /**
     动态规划：
     首先确定第0行的值，作为基准元素，以此求出接下行

     */
    public List<List<Integer>> generate(int numRows) {
        //创建一个集合存放结果
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        //判断输出数字
        if (numRows == 0) {
            return triangle;
        }
        //创建一个集合存放第0行元素
        List<Integer> row = new LinkedList<Integer>();
        //添加元素
        triangle.add(row);
        triangle.get(0).add(1);
        //使用动态规划
        for (int i = 1; i < numRows; i++) {
            List<Integer> rows = new LinkedList<Integer>();
            //得到当前行的上一行集合
            List<Integer> preRow = triangle.get(i - 1);
            //首先给每一行的第一个元素赋值
            rows.add(1);

            //给每一行除了第一个和最后一个元素赋值
            for (int j = 1; j < i; j++) {
                rows.add(preRow.get(j - 1) + preRow.get(j));
            }

            //给每一行的最后一个元素赋值
            rows.add(1);
            //将此行集合加入结果中
            triangle.add(rows);
        }

        return triangle;
    }
}
