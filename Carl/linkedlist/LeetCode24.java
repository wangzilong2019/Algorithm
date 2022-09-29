package com.carl.linkedlist;

public class LeetCode24 {


    /**
     * 题目链接：https://leetcode.cn/problems/swap-nodes-in-pairs/
     */
    /**
     * 思路：这里即为进行循环模拟。但注意指针之间不要弄混
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //创建一个头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //创建遍历指针
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            //记录下一个节点和下下一个节点
            ListNode after1 = cur.next;
            ListNode after3 = cur.next.next.next;
            //进行指针变换
            cur.next = cur.next.next;
            cur.next.next = after1;
            cur.next.next.next = after3;

            //当前节点后移动俩个位置
            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
