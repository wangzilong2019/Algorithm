package bit.algorithm.tree;

public class JZ23VerifySquenceOfBST {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int [] sequence, int start, int end) {
        //在查找过程中区域不断缩小，当为空时，证明之前所有的范围都满足检测条件
        //也就是一个BST
        if (start >= end) {
            return true;
        }
        //拿到节点的root
        int root = sequence[end];
        //先遍历左半部分，也就是整体比root小，拿到左子树的序列
        int i = 0;
        while (i < end && sequence[i] < root) {
            i++;
        }
        //检测右子树的值是否符合大于root的条件
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //到这说明当前序列满足需求，但并不代表问题被解决了，还要检测left和right是否满足条件
        return VerifySquenceOfBST(sequence, 0, i-1) && VerifySquenceOfBST(sequence, i, end - 1);
    }
}
