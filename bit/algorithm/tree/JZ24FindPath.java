package bit.algorithm.tree;

import java.util.ArrayList;

public class JZ24FindPath {
    /**
     * 输入一颗二叉树的根节点和一个整数，
     * 按字典序打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
     */
    /**
     *  采用回溯法：
     *     1、先添加值
     *     2、判断现有结果是否满足条件
     *     3、DFS
     *     4、回退（目的检测下一个）
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //结果集
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        //待选结果集
        ArrayList<Integer> list = new ArrayList<Integer>();
        FindPath(root, target, result, list);
        return result;
    }

    public void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        //这里若节点值都为正整数时可以另加target < 0这个条件
        if (root == null) {
            return;
        }
        //添加结果到待选结果中
        list.add(root.val);
        target -= root.val;
        //剪树枝判定
        //此时已经时叶子节点且路径和为target
        if (root.left == null && root.right == null && target == 0) {
            //将待选结果放入结果集中
            res.add(new ArrayList<Integer>(list));  //这里注意深浅拷贝
        }
        //DFS搜索
        FindPath(root.left, target, res, list);
        FindPath(root.right, target, res, list);

        //回溯
        //仔细思考，若要时回溯的话，条件是左子节点和右子节点都不再满足继续搜索的条件，即子节点废了，所以才回溯
        list.remove(list.size() - 1);
    }
}
