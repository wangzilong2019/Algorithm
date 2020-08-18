package bit.algorithm.tree;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class JZ59Print {
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     */
    /**
     * 上一层存在队列中，则本层存在栈中，这样可以交替打印成之字型
     * 如果当前层是从左到右的顺序访问，下层入栈的顺序与当前层访问顺序一致
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> deque = new LinkedList<>();
        int dir = 1; //1、left->right. 2、right->left
        ArrayList<Integer> list = new ArrayList<>();;
        //根节点入栈
        stack.add(pRoot);
        while (!stack.empty()) {

            while (!stack.empty()) {
                //之字形打印二叉树
                TreeNode curr = stack.peek();
                stack.pop();
                //入队
                list.add(curr.val);
                TreeNode first= (dir == 1) ? curr.left : curr.right;
                TreeNode second = (dir == 1) ? curr.right : curr.left;

                //层序遍历
                if (first != null) {
                    deque.offer(first);
                }
                if (second != null) {
                    deque.offer(second);
                }
            }
            //这里注意若不是生成一个ArrayList对象则结果集中无
            lists.add(new ArrayList<>(list));  //一定要注意浅拷贝问题
            while (!deque.isEmpty()) {
                stack.push(deque.poll());
            }
            list.clear();
            dir = (dir == 1) ? 2 : 1;
        }
        return lists;
    }
}
