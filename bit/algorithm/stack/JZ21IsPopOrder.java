package bit.algorithm.stack;

import java.util.Stack;

public class JZ21IsPopOrder {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，
     * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     */
    /**
     *  首先模拟一个弹栈序列，假设入栈序列是pushv,弹栈序列是popv
     *  popv的第一个元素，一定时最后入栈的，最先弹栈的，入栈时一定顺序的
     *  也就决定了，我们必须一直入栈，直到碰到popv的第一个元素，然后开始弹栈
     *  最后在这个循环过程，如果右符合要求的，最后的栈结构一定是空的
     *  1、遍历入栈序列，只要popv的第一个数据和当前pushv的数据不相等，椅子和入栈
     *  2、只要st栈顶的值和popv出栈的序列是相等的，则一直执行出栈逻辑
     *  3、st.empty()
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        int i = 0;
        int j = 0;
        //创建一个栈
        Stack<Integer> stack = new Stack<Integer>();
        //遍历入栈序列
        for (; i < pushA.length; i++) {
            //入栈操作
            stack.push(pushA[i]);
            //执行弹栈操作
            while (!stack.empty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.empty();
    }
}
