package bit.algorithm.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class JZ22PrintFromTopToBottom {

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    /**
     * 采用队列的方式：
     *  首先将头节点入队
     *  然后当队列不为空时取出头节点，将左子节点右子节点入队
     *  方式一用LinkedList集合模拟队列
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        //创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将第一个元素入队
        queue.addLast(root);
        //当队列不为空时循环操作
        while (queue.size() != 0) {
            //获取队头元素且出队
            TreeNode node = queue.removeFirst();
            //放入集合中
            list.add(node.val);
            //遍历左节点
            if (node.left != null) {
                queue.addLast(node.left);
            }
            //遍历右子节点
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return list;
    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        //创建一个队列
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        //将第一个元素入队
        queue.add(root);
        //当队列不为空时循环操作
        while (!queue.isEmpty()) {
            //获取队头元素且出队
            TreeNode node = queue.pop();
            //放入集合中
            list.add(node.val);
            //遍历左节点
            if (node.left != null) {
                queue.add(node.left);
            }
            //遍历右子节点
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
