package bit.algorithm.tree;

public class JZ18Mirror {
    /**
     * 二叉树的镜像，采用递归方式简单（从上到下镜像）
     *   市值是前序遍历
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        //对根节点root进行镜像操作
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //对root的左子树镜像
        Mirror(root.left);
        //对root的右子树镜像
        Mirror(root.right);
    }

    /**
     *方式二：自下向上镜像
     * @param root
     */
    public void Mirror2(TreeNode root) {
        if (root == null) {
            return;
        }
        //对root的左子树镜像
        Mirror(root.left);
        //对root的右子树镜像
        Mirror(root.right);
        //对根节点root进行镜像操作
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
