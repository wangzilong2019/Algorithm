package com.carl.linkedlist;

public class LeetCode19 {

    /**
     * 题目链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
     */

    /**
     * 思路：采用双指针的方法，仅仅遍历一次，这里先让快指针走n+1步，
     * 然后快慢指针同时走，当快指针为空时，慢指针所指向的下一个节点即为待删除的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //创建一个头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //设置快指针、慢指针
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        //先让快指针走n+1步
        int i = 0;
        while (i++ <= n) {
            fast = fast.next;
        }
        //俩指针同时移动知道fast指向空
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //删除目标节点
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
