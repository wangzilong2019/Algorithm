package com.carl.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * 思路：层次遍历二叉树，找到每层最大值加入集合中即可
 */
public class LeetCode515 {
    public List<Integer> largestValues(TreeNode root) {
        //创建结果集
        List<Integer> res = new LinkedList<>();
        //合法性判断
        if (root == null) {
            return res;
        }
        //创建队列
        Deque<TreeNode> deque = new LinkedList<>();
        //根节点加入队列中
        deque.offer(root);
        //层次遍历二叉树
        while (!deque.isEmpty()) {
            //记录当前层节点个数
            int size = deque.size();
            //记录当前层节点的最大值
            int max = Integer.MIN_VALUE;
            //遍历当前层节点
            while (size-- != 0) {
                //当前对头元素出队
                TreeNode cur = deque.poll();
                //寻找本层节点的最大值
                max = Math.max(max, cur.val);
                //当前节点左右节点不为空则加入队列中
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
            //将当前层节点最大值加入集合中
            res.add(max);
        }
        return res;
    }
}
