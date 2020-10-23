package bit.algorithm.linked;

public class JZ16Merge {
    /**
     *  方法一：
     *      首先定义俩个指针指向俩个链表头，然后遍历
     *      比较每个节点的大小，然后新建立一个链表插入
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        //判断链表是否为空
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //定义一个新链表的首尾节点
        ListNode head = null;
        ListNode end = null;

        //遍历俩个链表找到节点val值小的插入
        while (list1 != null && list2 != null) {
            //找到值较小的节点
            ListNode temp = list1.val <= list2.val ? list1 : list2;
            //在原链表中删除节点
            if (temp == list1) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
            //因为尾插法创建链表要不带头节点，所i以收益插入情况要判断是否为首次插入
            if (head == null) {
                //首次插入
                head = temp;
                end = head;
            } else {
                //非首次插入
                end.next = temp;
                end = temp;
            }
        }

        //判断lis1链表是否合并完
        if (list1 != null) {
            end.next = list1;
        }else if (list2 != null) {
            end.next = list2;
        }
        return head;
    }

    /**
     *  采用递归法:
     *      将子问题分割：每一步都进行相同类型操作
     *      每次将问题规模缩小
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //创建一个新链表的第一个节点
        ListNode head = null;
        //判断值
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        //合并剩下的节点（每次阿静问题规模缩小，进行相同类型操作）
        head.next = merge(list1, list2);
        return head;
    }
}
