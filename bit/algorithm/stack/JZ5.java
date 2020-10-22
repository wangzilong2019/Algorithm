package bit.algorithm.stack;

import java.util.Stack;

public class JZ5 {

    /**
     * 一个栈用来入栈，另一个用来弹栈
     */
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //因为弹出元素都是从stack2中，所以要现判断stack2是否为空
        if (stack2.isEmpty()) {
            //将stack1中元素弹入stack2中
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
