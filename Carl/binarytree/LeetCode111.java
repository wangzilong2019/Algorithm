package com.carl.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目链接：https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 *   思路：二叉树最小深度即为此节点左右孩子都为空
 */
public class LeetCode111 {
    public int minDepth(TreeNode root) {
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
                //是否为最小深度
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                //当前节点左右节点不为空则加入队列
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
