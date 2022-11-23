package com.carl.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 *      思路：层次遍历二叉树，遍历每层节点时设置指针即可
 */
public class LeetCode116 {
    public Node connect(Node root) {
        //合法性判断
        if (root == null) {
            return root;
        }
        //创建队列
        Deque<Node> deque = new LinkedList<>();
        //根节点加入队列中
        deque.offer(root);
        //层次遍历二叉树
        while (!deque.isEmpty()) {
            //记录当前层节点数
            int size = deque.size();
            //记录当前对头元素（即为每层第一个元素）
            Node preCur = deque.poll();
            //当前节点左右节点不为空则加入队列
            if (preCur.left != null) {
                deque.offer(preCur.left);
            }
            if (preCur.right != null) {
                deque.offer(preCur.right);
            }
            //依次遍历剩余元素并处理
            for (int i = 1; i < size; i++) {
                //当前元素出队
                Node cur = deque.poll();
                //用next指针链接起来
                preCur.next = cur;
                //指针后移
                preCur = preCur.next;
                //当前元素cur左右节点不为空则加入队列
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}