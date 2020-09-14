package bit.algorithm.recall;

import java.util.ArrayList;
import java.util.List;

public class L39CombinationSum {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allRet = new ArrayList<>();
        List<Integer> curRet = new ArrayList<>();
        int curSum = 0;
        dfs(candidates, allRet, curRet, curSum, target, 0);
        return allRet;
    }

    public void dfs(int[] candidates, List<List<Integer>> allRet, List<Integer> curRet, int curSum, int target, int prev) {
        //判断是否到达终点
        if (curSum >= target) {
            if (curSum == target) {
                //将可行解放入结果集合中
                allRet.add(new ArrayList<>(curRet));
            }
            return;
        }

        //累加起始位置为上一项的位置
        for (int i = prev; i < candidates.length; i++) {
            curRet.add(candidates[i]);
            //深度优先搜索
            dfs(candidates, allRet, curRet, curSum + candidates[i], target, i);
            //回溯
            curRet.remove(curRet.size() - 1);
        }
    }

    /**
     *         //创建二维数组初始化
     *         A[10][10];
     *         for (i 0 to 9) {
     *             for (j 0 to 9) {
     *                 A[i][j] = 10 * i + j;
     *             }
     *         }
     *
     *         //创建三维数组初始化
     *         B[10][10][10];
     *         for (i 0 to 9) {
     *             for (j 0 to 9) {
     *                 for (k 0 to 9) {
     *                     B[i][j][k] = 100 * i + 10 * j + k + 1;
     *                 }
     *             }
     *         }
     */

   /* //判断一个数字是否为素数
    boolean isPrime(num) {
        if (num < 2) {
            false;
        }

        for (i 2 to sqrt(num)) {
            if (num % i == 0 ) {
                false;
            }
        }
        true;
    }

    int sumDoulePrime() {
        *
         * 找出二维数组中质数并相加

        sum = 0;
        for (i 0 to 9) {
            for (j 0 to 9) {
                //判断此元素是否为素数
                if (isPrime(A[i][j])) {
                    sum += i;
                }
            }
        }
        sum;
    }

    int sumDoulePrime() {
        *
         * 找出三维数组中质数并相加

        sum = 0;
        for (i 0 to 9) {
            for (j 0 to 9) {
                for (k 0 to 9) {
                    //判断此元素是否为素数
                    if (isPrime(B[i][j][k])) {
                        sum += B[i][j][k];
                    }
                }
            }
        }
        sum;
    }*/




}
