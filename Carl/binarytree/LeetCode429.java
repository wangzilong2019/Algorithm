package com.carl.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 *      思路：层次遍历N叉树，思路一样
 */
public class LeetCode429 {
    public List<List<Integer>> levelOrder(Node root) {
        //创建结果集合
        List<List<Integer>> res = new LinkedList<>();
        //合法性判断
        if (root == null) {
            return res;
        }
        //创建队列
        Deque<Node> deque = new LinkedList<>();
        //根节点加入队列
        deque.offer(root);
        //层次遍历N叉树
        while (!deque.isEmpty()) {
            //记录当前层节点数
            int size = deque.size();
            //创建集合存放当前层节点
            List<Integer> list = new LinkedList<>();
            //遍历当前层节点
            while (size-- != 0) {
                //当前对头元素出队
                Node cur = deque.poll();
                //当前节点加入当前层集合中
                list.add(cur.val);
                //记录当前节点孩子的个数
                int childSize = cur.children.size();
                //孩子节点不为空则加入队列中
                for (int i = 0; i < childSize; i++) {
                    deque.offer(cur.children.get(i));
                }
            }
            //当前层节点val集合加入结果集合中
            res.add(new LinkedList<>(list));
        }
        return res;
    }
}
