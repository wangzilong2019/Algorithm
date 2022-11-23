package com.carl.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 *   思路：层次遍历二叉树，计算每层val之和然后在计算平均值
 *
 */
public class LeetCode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        //创建队列
        Deque<TreeNode> deque = new LinkedList<>();
        //创建结果集合
        List<Double> res = new LinkedList<>();
        //根节点加入队列中
        deque.offer(root);
        //层次遍历二叉树
        while (!deque.isEmpty()) {
            //记录当前层节点数
            int size = deque.size();
            //记录当前层节点val之和
            double sum = 0;
            //遍历当前层节点
            for (int i = 0; i < size; i++) {
                //当前对头节点出队
                TreeNode cur = deque.poll();
                //累加和
                sum += cur.val;
                //当前左右节点不为空则加入队列
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
            //计算当前层平均和并加入结果集中
            res.add(sum / size);
        }
        return res;
    }
}
