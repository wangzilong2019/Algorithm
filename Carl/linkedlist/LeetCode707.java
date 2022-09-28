package com.carl.linkedlist;

public class LeetCode707 {

    //记录有效节点的个数和头节点
    int size;
    ListNode head;
    ListNode rear;

    public MyLinkedList() {
        size = 0;
        //创建头节点
        head = new ListNode(-1);
        rear = head;
    }

    public int get(int index) {
        //判断索引是否有效
        if (index < 0 || index >= size) {
            return -1;
        }
        //遍历计数节点
        int cnt = 0;
        ListNode p = head;
        while (cnt++ <= index) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        //创建一个新节点
        ListNode node = new ListNode(val);
        //插入节点
        node.next = head.next;
        head.next = node;
        //有效节点个数增加
        size++;
    }

    public void addAtTail(int val) {
        //创建一个新节点
        ListNode node = new ListNode(val);
        //插入节点到链表尾部
        rear.next = node;
        //更新尾节点
        rear = node;
        //有效节点个数增加
        size++;
    }

    public void addAtIndex(int index, int val) {
        //判断插入位置是否合法
        if (index > size) {
            return;
        }
        //创建一个新节点
        ListNode node = new ListNode(val);
        //当插入位置为尾节点时
        if (index == size) {
            rear.next = node;
            rear = node;
            size++;
        } else if (index < 0) {
            //在头部插入节点
            node.next = head.next;
            head.next = node;
            if (size == 0) {
                rear = rear.next;
            }
            size++;
        } else {
            //定义一个指针
            ListNode p = head;
            //定义一个计数器
            int cnt = 0;
            while(cnt++ < index) {
                p = p.next;
            }
            node.next = p.next;
            p.next = node;
            size++;
        }

    }

    public void deleteAtIndex(int index) {
        //判断是否合法
        if (index < 0 || index >= size) {
            return;
        }
        int cnt = 0;
        ListNode p = head;
        //当删除的为尾节点时
        if (index == size - 1) {
            while (cnt++ < index) {
                p = p.next;
            }
            p.next = null;
            rear = p;
            size--;
        } else {
            while (cnt++ < index) {
                p = p.next;
            }
            p.next = p.next.next;
            size--;
        }
    }
}
