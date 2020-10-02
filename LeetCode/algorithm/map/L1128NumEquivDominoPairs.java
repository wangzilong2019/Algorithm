package leetcode.algorithm.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;

public class L1128NumEquivDominoPairs {
    /**
     * 给你一个由一些多米诺骨牌组成的列表 dominoes。
     *
     * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
     *
     * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
     *
     * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     *
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) {
                    count++;
                } else if (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     *  方法二：
     *    自认为非常好的方法
     *    因为正反只要满足即可作为一对、可以先对每对排序，这样比较固定
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs2(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for (int[] arr : dominoes) {
            Arrays.sort(arr);
            ans += cp[arr[0] * 10 + arr[1]]++;
        }
        return ans;
    }
}
