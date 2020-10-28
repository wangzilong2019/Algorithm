package bit.algorithm.test.recall;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 3};
        List<List<Integer>> res = combinationSum(arr, 10);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allRet = new ArrayList<>();
        List<Integer> curRet = new ArrayList<>();
        int curSum = 0;
        dfs2(candidates, allRet, curRet, target, curSum, 0);
        return allRet;
    }

    private static void dfs(int[] candidates, List<List<Integer>> allRet, List<Integer> curRet, int target, int curSum, int prev) {
        if (curSum >= target) {
            //当为目标数字时加入集合中
            if (curSum == target) {
                allRet.add(new ArrayList<>(curRet));
            }
            return;
        }

        for (int i = prev; i < candidates.length; i++) {
            curRet.add(candidates[i]);
            dfs(candidates, allRet, curRet, target, curSum + candidates[i], i);
            curRet.remove(curRet.size() - 1);
        }
    }

    /**
     * 这里每个数只用一次
     * @param candidates
     * @param allSet
     * @param curSet
     * @param target
     * @param curSum
     * @param idx
     */
    public static void dfs2(int[] candidates, List<List<Integer>> allSet, List<Integer> curSet, int target, int curSum, int idx) {
        if (curSum >= target) {
            if (curSum == target) {
                allSet.add(new ArrayList<>(curSet));
            }
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            curSet.add(candidates[i]);
            dfs2(candidates, allSet, curSet, target, curSum + candidates[i], i + 1);
            curSet.remove(curSet.size()-1);
        }
    }
}
