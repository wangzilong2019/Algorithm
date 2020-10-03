package bit.algorithm.interesting.greed;

import java.util.Arrays;
import java.util.Comparator;

public class RuckSackProblem {
    /**
     *  背包问题：
     *     使用贪心算法，通过求每个物品性价比的平均值来选择性价比高的放进去
     *     每次遍历物品，判断此物品和背包剩余空间的关系，来判断是否放入或切割
     * @param args
     */
    public static void main(String[] args) {

    }
}

class Node {
    double w; //每个物品的重量
    double v; //每个物品的价格
    double p; //每个物品的性价比

    public Node(double p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Node{" +
                "p=" + p +
                '}';
    }
}
