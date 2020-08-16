package bit.algorithm.tree;

public class JZ38TreeDepth {
    /**
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */
    /**
     * 递归法求树的深度
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left),TreeDepth( root.right));
    }

    /**
     *  方法二：采用层次遍历方法
     * @param root
     * @return
     */
    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        int[] max = new int[1];
        treeDepthHelper(root, depth, max);
        return max[0];
    }

    public void treeDepthHelper(TreeNode root, int depth, int[] max) {
        if (root == null) {
            if (max[0] < depth) {
                max[0] = depth;
            }
            return;
        }
        treeDepthHelper(root.left, depth + 1, max);
        treeDepthHelper(root.right, depth + 1, max);
    }
}
