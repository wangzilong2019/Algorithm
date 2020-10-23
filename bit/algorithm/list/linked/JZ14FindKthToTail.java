package bit.algorithm.linked;

public class JZ14FindKthToTail {
    /**
     * 定义俩个指针：先让一个指针走K步，然后俩个指针同时走，直到先走的那个到达终点，第二个即为倒数第5个
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k){
        if (head == null || k < 0) {
            return null;
        }

        //定义俩个指针
        ListNode front = head;
        ListNode rear = head;

        //首先让第一个指针移动5个位置
        /**
         *  注意这里
         */
        while (k > 0 && front != null) {
            front = front.next;
            k--;
        }
        //然后移动俩个指针，当第一个指针到达尾部时，第二个再倒数第五个位置
        while (front != null) {
            front = front.next;
            rear = rear.next;
        }
        //此种判断链表长度是否大于5
        return k > 0 ? null : rear;
    }

    /**
     * 单指针法，先求出总，正向走
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head,int k){
        if (head == null || k < 0) {
            return head;
        }
        //记录总节点数
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (k > count) {
            return null;
        }
        int n = count - k;
        ListNode t = head;
        while (n-- != 0) {
            t = t.next;
        }
        return n > 0 ? null : t;
    }


}

