package com.carl.linkedlist;

import java.util.Stack;

public class LeetCode206 {

    /**
     * 题目链接：https://leetcode.cn/problems/reverse-linked-list/
     */

    /**
     * 思路：若要使再创建一个新链表则浪费空间，所以只需要改变指针的方向即可
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //创建前驱以及当前指针
        ListNode prev = null;
        ListNode cur = head;
        //创建一个临时变量
        ListNode afterv = null;
        while (cur != null) {
            //记录下一个节点
            afterv = cur.next;
            //改变当前指针指向
            cur.next = prev;
            prev = cur;
            cur = afterv;
        }
        return prev;
    }

    /**
     * 思路二：采用递归的方法
     * @param prev
     * @param cur
     * @return
     */
    public ListNode reverseList2(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        //记录下一个节点
        ListNode afterV = cur.next;
        //转置指针
        cur.next = prev;
        //指针后移
        prev = cur;
        cur = afterV;
        //进行下一次递归
        return reverseList2(cur, afterV);
    }
}
