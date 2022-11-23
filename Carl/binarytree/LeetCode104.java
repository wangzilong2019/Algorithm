package com.carl.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目链接： * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *     思路：层次遍历二叉树记录深度
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        //合法性判断
        if (root == null) {
            return 0;
        }
        //记录二叉树深度
        int depth = 0;
        //创建队列
        Deque<TreeNode> deque = new LinkedList<>();
        //根节点加入队列
        deque.offer(root);
        //层次遍历二叉树
        while (!deque.isEmpty()) {
            //记录当前层节点数
            int size = deque.size();
            //层数加1
            depth++;
            //遍历当前层节点
            while (size-- != 0) {
                //当前对头元素出队
                TreeNode cur = deque.poll();
                //左右节点不为空则加入队列中
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }
        return depth;
    }
}
