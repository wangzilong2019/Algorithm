package bit.algorithm.recall;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TotalNumberCombination {
    public static void main(String[] args) {

        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(5);
        coins.add(10);
        int totalNum = 0;
        // dfs(coins, totalNum, 0, 20, 0);
        System.out.println(totalNum);
    }

    public static void dfs(List<Integer> list, int totalNum, int curNum, int target, int pre) {
        if (curNum >= target) {
            if (curNum == target) {
                totalNum++;
            }
            return;
        }
        for (int i = pre; i <= list.size(); i++) {
            if (list.get(i) > target) {
                continue;
            }
            dfs(list, totalNum, curNum + list.get(i), target, i);
        }
    }
}
