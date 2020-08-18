package bit.algorithm.tree;

import java.util.Stack;

public class JZ62KthNode {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     */
    /**
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        //因为左子树的最左节点为最小值，而要从根节点访问，因此使用栈结构
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        //stack.push(pRoot);  若用while循环要先入栈
        do {
            //左子树入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                k--;
                //判断是否找到
                if (k == 0) {
                    return node;
                }
                //再右子树中寻找
                node = node.right;
            }
        } while (node != null || !stack.empty());  //循环条件对应只有左子树和只有右子树的俩种情况

        //当待查找节点大于树的总节点数时
        return null;
    }
}
