package bit.algorithm.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L419LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
         //创建一个队列
        Queue<Node> queue = new LinkedList<>();
        //当前根节点不为空时入队
        queue.offer(root);

        //创建一个集合存储结果集合
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            //计算当前队列中元素的个数
            int size = queue.size();
            //创建一个集合存储当前元素所在行的元素
            List<Integer> rowList = new ArrayList<>();
            while (size != 0) {
                size--;
                //获取当前队头节点
                Node cur = queue.peek();
                //当前队头节点出队
                queue.poll();
                rowList.add(cur.val);
                //当当前元素的子节点入队
                for (Node node : cur.children) {
                    queue.offer(node);
                }
            }
            //将当前行的结果加入结果集合中
            res.add(rowList);
        }
        return res;
    }
}


class Node {
    int val;
    List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
