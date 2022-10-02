package com.carl.linkedlist;

public class LeetCode142 {
    /**
     * 题目链接：https://leetcode.cn/problems/linked-list-cycle-ii/
     */
    /**
     * 思路：这里先判断是否有环，然后再找到入口
     * 判断是否有环的方法：设置俩个快慢指针：
     * 快指针每次走2步，慢指针每次走1步，当俩指针相遇时则存在换（可以数学推导）
     * 找环的入口：
     * 设置俩个指针一个指向头节点、另一个指向相遇节点的指针，当俩指针相遇即为环的入口节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //定义俩个快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //判断是否有环
            if (slow == fast) {
                //有环则找入口，一个指针指向头节点，另一个指针指向相遇节点
                ListNode index1 = head;
                ListNode index2 = fast;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
