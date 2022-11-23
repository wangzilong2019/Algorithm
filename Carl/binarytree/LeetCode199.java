package com.carl.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * 题目链接：https://leetcode.cn/problems/binary-tree-right-side-view/
 *      右视图的构成：每层的最后一个元素
 *      思路：层次遍历二叉树然后添加每层的最后一个元素
 *
 */
public class LeetCode199 {

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        //创建集合存放结果
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        //创建队列
        Deque<TreeNode> deque = new LinkedList<>();
        //根节点加入队列中
        deque.offer(root);
        //层次遍历二叉树
        while (!deque.isEmpty()) {
            //记录当前层节点数
            int size = deque.size();
            //处理当前层节点
            while (size-- != 0) {
                //当前对头元素出队
                TreeNode cur = deque.poll();
                //当为本层最后一个元素则加入结果集合中
                if (size == 0) {
                    res.add(cur.val);
                }
                //左右节点不为空则加入队列中
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }
        return res;
    }
}
