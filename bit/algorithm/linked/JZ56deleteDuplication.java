package bit.algorithm.linked;

public class JZ56deleteDuplication {

    /**
     * 在一个排序的链表中，存在重复的结点，
     * 请删除该链表中重复的结点，重复的结点不保留，
     * 返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *   注意在单链表中去重范围最好是一个前开后闭区间，这样便于操作
     *   先确定重复区间起始位置，再确定重复区间范围
     */
    public ListNode deleteDuplication(ListNode pHead) {
        //首先判断链表是否有效
        if (pHead == null) {
            return pHead;
        }
        //创建一个头节点指向链表的第一个节点，便于操作
        ListNode head = new ListNode(0);
        head.next = pHead;
        //创建俩个指针代表重复范围，左开右闭
        ListNode pre = head;
        ListNode last = pre.next;

        while (last != null) {
            //先确定重复区域起始位置
            while (last.next != null && last.val != last.next.val) {
                pre = last;
                last = last.next;
            }
            //确定重复区域
            while (last.next != null && last.val == last.next.val) {
                last = last.next;
            }
            /**
             * 1、last.next != null pre, last 确定一段范围 pre->next = last.next
             * 2、last.next == null, pre, last 确定一段范围 pre->next = last.next（null）
             * 3、last.next == null  整张链表无重复节点
             */
            if (pre.next != last) {
                pre.next = last.next;
            }
            last = last.next;
        }
        return head.next;
    }
}
