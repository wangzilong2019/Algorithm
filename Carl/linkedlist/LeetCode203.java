package com.carl.linkedlist;

public class LeetCode203 {
    /**
     * 题目链接：https://leetcode.cn/problems/remove-linked-list-elements/
     */

    /**
     * 思路：这里删除链表节点操作，添加一个头节点遍历即可
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //合法性判断
        if (head == null) {
            return null;
        }
        //创建一个头节点便于删除操作
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        //定义一个指针
        ListNode p = headNode;
        ListNode s = null;
        //遍历链表
        while (p.next != null) {
            //判断是否满足条件
            if (p.next.val == val) {
                s = p.next;
                p.next = s.next;
            } else {
                p = p.next;
            }
        }
        return headNode.next;
    }
}
