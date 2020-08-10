package bit.algorithm.linked;

public class JZ15ReverseList {
    /**
     *  定义三个指针：先反转，再后移、再判断空
     *      再原链表上进行改动
     */
    public ListNode ReverseList(ListNode head) {
        //当头节点为空或是只有一个节点时，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        //至少右俩个节点
        ListNode left = head;
        ListNode mid = left.next;
        ListNode right = mid.next;  //此节点有可能为空
        //当right节点存在时则所有节点都存在
        while (right != null) {
            //反转
            mid.next = left;
            //后移
            left = mid;
            mid = right;
            right = right.next;
        }
        //注意上面只是反转了前n-1个节点
        //此时反转尾节点
        mid.next = left;
        //head一直时指向第一个节点没有变且head.next仍指向第二个节点，此时让它断链
        head.next = null;
        head = mid;
        return head;

    }

    /**
     * 方法二：采用头插法
     */
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //新建一个链表头节点
        ListNode new_head = null;
        //至少为2个节点
        while (head != null) {
            //取出节点
            ListNode temp = head;
            head = head.next;
            //头插法建立链表
            temp.next = new_head;
            new_head = temp;
        }

        return new_head;
    }
}
