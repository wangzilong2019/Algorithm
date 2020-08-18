package bit.algorithm.linked;

public class JZ36FindFirstCommonNode {

    public int getLinkedLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    /**
     * 输入两个链表，找出它们的第一个公共结点。
     * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     */
    /**
     *   首先求出俩个链表的长度的差值step，让长链表先走step步
     *   然后再同时走，判断有无公共节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //判断输入是否有效
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //计算俩个链表的长度
        int len1 = getLinkedLen(pHead1);
        int len2 = getLinkedLen(pHead2);

        int step = Math.abs(len1 - len2);
        //判断哪个链表长，然后先走step步
        if (len1 > len2) {
            while (step > 0) {
                pHead1 = pHead1.next;
                step--;
            }
        } else {
            while (step > 0) {
                pHead2 = pHead2.next;
                step--;
            }
        }
        //俩个链表都往后走
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        //没有公共节点
        return null;
    }
}
