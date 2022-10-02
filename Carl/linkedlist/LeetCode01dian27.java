package com.carl.linkedlist;

public class LeetCode01dian27 {

    /**
     * 题目链接：https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
     */
    /**
     * 思路：求出俩个链表长度之差，让长链表先走差步，之后一起走
     * 这里注意链表相交时是指针相等而不是值相等
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //合法性判断
        if (headA == null || headB == null) {
            return null;
        }
        //记录链表长度
        int lenA = 0;
        int lenB = 0;
        //定义指针
        ListNode curA = headA;
        ListNode curB = headB;
        //求链表长度
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        //让curA指向长链表lenA记录响应的长度
        if (lenB > lenA) {
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;

            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

}
