package lanqiao.algorithm.dp;

import java.util.Arrays;

public class NumTrees96 {
    /**
     解法一：
     F[i][n]  表示以i为根，长度为n的二叉搜索树的个数
     G[n] 表示长度为n的二叉搜索树的个数
     考虑到边界情况G[0] = G[1] = 0;
     G[n] = sum(F[i][n]) i取值为1到n
     优化之后：
     F[i][n] = G[i-1]*G[n-i]
     G[n] = sum(G[i-1]*G[n-i])  i从1到n

     */
    public int numTrees(int n) {
        //创建数组来存放长度为n的二叉搜索树的个数
        int[] G = new int[n+1];
        //初始化边界情况
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }

    /**
     解法二：卡塔兰树
     利用公式：
     C0 = 1;
     Cn = 2*(2*n+1)/(n+2)Cn;  n范围1到n
     */
    public int numTrees2(int n) {
        //初始化，当长度为0时
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c*2*(2*i+1)/(i+2);
        }
        return (int)c;
    }

    public static void main(String[] args) {

    }
}
