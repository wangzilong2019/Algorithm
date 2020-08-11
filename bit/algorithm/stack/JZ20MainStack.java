package bit.algorithm.stack;

import java.util.Stack;

public class JZ20MainStack {

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     */

    /**
     * 建立俩个栈：
     *     一个栈用来存储数据
     *     另一个作为辅助栈：
     *      与原栈中的数据保持一致
     *      栈顶元素代表当前已入栈元素的最小值
     *      即每个位置代表存储元素栈中之前元素的最小值
     * @param node
     */
    private Stack<Integer> dataStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        //当辅助栈为空或是当前元素小于辅助栈栈顶元素时
        if (minStack.empty() || node < minStack.peek()) {
            //此元素入栈
            minStack.push(node);
        } else {
            //当栈辅助栈不为空且当前元素大于辅助栈栈顶元素时
            minStack.push(minStack.peek());
        }
        //入数据栈
        dataStack.push(node);
    }

    /**
     * 要保证俩个栈元素个数相等则同时出栈
     */
    public void pop() {
        if (dataStack.size() == 0 || minStack.size() == 0) {
            return;
        }
        dataStack.pop();
        minStack.pop();
    }

    /**
     * 返回数据栈中栈顶元素
     * @return
     */
    public int top() {
        return dataStack.peek();
    }

    //辅助栈中栈顶时当前栈中元素最小值
    public int min() {
        return minStack.peek();
    }
}
