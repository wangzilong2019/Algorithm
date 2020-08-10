package bit.algorithm.tree;

public class JZ17HasSubtree {
    /**
     * 判断树root2是否为root1的子结构
     * 一棵树是否是另一颗树的子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //空树不是任何子结构
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        //首先找起始位置
        if (root1.val == root2.val) {
            //判断俩颗树的左子树右子树是否满足条件
            result = isSameChild(root1, root2);
        }
        //在左子树赵
        if (result != true) {
            result = HasSubtree(root1.left, root2);
        }
        //在右子树找
        if (result != true) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }


    /**
     * 在确定起始位置的根节点的情况在比较左子树右子树是否满足条件
     * @param begin
     * @param begin_sub
     * @return
     */
    public boolean isSameChild(TreeNode begin, TreeNode begin_sub) {
        if (begin_sub == null) {
            return true;
        }
        if (begin == null) {
            return false;
        }

        if (begin.val != begin_sub.val) {
            return false;
        }
        //说明当前节点是相等的
        return isSameChild(begin.left, begin_sub.left) && isSameChild(begin.right, begin_sub.right);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
