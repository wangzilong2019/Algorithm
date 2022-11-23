package com.carl.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 *   思路：正常的层次遍历然后在反转
 */
public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //创建集合存放每一层遍历结果
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        //将根节点加入队列中
        deque.push(root);
        //层次遍历二叉树
        while (!deque.isEmpty()) {
            //记录当前层节点数
            int size = deque.size();
            //存放下一层节点
            List<Integer> list = new LinkedList<>();
            //处理当前层节点
            while (size-- != 0) {
                //记录当前节点
                TreeNode curNode = deque.poll();
                list.add(curNode.val);
                //左节点不为空加入队列中
                if (curNode.left != null) {
                    deque.offer(curNode.left);
                }
                //右节点不为空加入队列中
                if (curNode.right != null) {
                    deque.offer(curNode.right);
                }
            }
            res.add(new LinkedList<>(list));
        }

        //创建结果集合
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            ans.add(res.get(i));
        }
        return ans;
    }
}
