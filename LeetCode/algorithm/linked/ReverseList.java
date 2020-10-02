package leetcode.algorithm.linked;

public class ReverseList {
    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //始终指向当前已反转好节点
        ListNode pre = null;
        //始终指向正在反转节点的下一个节点，即下一次带反转节点
        ListNode next = null;
        while (head != null) {
            //next始终指向带反转节点的下一个节点
            next = head.next;
            //head为当前正在反转的节点，指向上一个反转好的节点头
            head.next = pre;
            //pre指向刚刚反转好的节点
            pre = head;
            //更改下一次循环带反转节点
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newNode = new ReverseList().reverseList(node1);
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}
