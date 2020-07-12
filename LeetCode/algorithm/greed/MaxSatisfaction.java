package leetcode.algorithm.greed;

import java.util.Arrays;
import java.util.Comparator;

public class MaxSatisfaction {
    /**
     采用菜系算法思路：
     将做菜满足度从大到小进行排序(这里从小到大逆序遍历)
     然后遍历满意度，当当前满意度加上之前的小于0则退出循环
     否则相加
     每次累加的过程相当于乘

     */
    public int maxSatisfaction(int[] satisfaction) {
        //对做菜满意度进行排序
        Arrays.sort(satisfaction);
        int presum = 0;   //记录当前元素最佳值
        int ans = 0; //记录结果
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (presum + satisfaction[i] > 0) {
                presum += satisfaction[i];
                ans += presum;
            } else {
                break;
            }
        }
        return ans;
    }
}
