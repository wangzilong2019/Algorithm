package leetcode.algorithm.linked;

public class L2AddTwoNumbers {
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        //创建一个新头节点
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //表示进位信息
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            //创建一个新节点
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        //判断最后是否有进位产生
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }