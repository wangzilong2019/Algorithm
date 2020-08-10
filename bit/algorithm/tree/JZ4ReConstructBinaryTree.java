package bit.algorithm;

public class JZ4ReConstructBinaryTree {

    /**
     *  思路：
     *     根据前序遍历序列找到根节点
     *     通过根节点在中序序列中找到左子树和右子树的序列然后递归构造二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;

    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //判断前序和中序序列是否为空
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        //构造根节点
        TreeNode root = new TreeNode(pre[startPre]);

        //递归构造左子树右子树
        for (int i = startIn; i <= endIn; i++) {
            //找到跟在中序序列的位置，继而得到左子树序列和右子树序列
            if (in[i] == root.val) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i -1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}


//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

