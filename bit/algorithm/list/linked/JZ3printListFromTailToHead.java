package bit.algorithm.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JZ3printListFromTailToHead {

    /**
     *  逆序打印链表
     *  逆序首先要想到先进后出即为栈
     */
    ArrayList<Integer> newList = new ArrayList<>();
    public List<Integer> printListFromTailToHead2(ListNode listNode) {
        //首先判断链表是否为空
        if (listNode == null) {
            return newList;
        }
        //创建一个栈
        Stack<Integer> stack = new Stack<>();
        //将元素入栈
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //将元素放入链表中
        while (!stack.empty()) {
            newList.add(stack.pop());
        }
        return newList;
    }

    //递归打印
    public void printListFromTailToHead (ListNode listNode, ArrayList<Integer> list) {
        //递归函数出口
        if (listNode == null) {
            return ;
        }
        //递归
        printListFromTailToHead(listNode.next, list);
        list.add(listNode.val);

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> newList = new ArrayList<>();
        printListFromTailToHead(listNode, newList);
        return newList;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}