package leetcode.algorithm.dp;

public class WiggleMaxLength376 {
    /**
     *   一、暴力解法：
     *       遍历数组，找到从每一个位置开始的最长摆动序列，直到遍历完数组
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        } else {
            return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
        }

    }

    /**
     *   计算从index索引开始的最长摆动序列
     * @param nums
     * @param index   数组开始索引
     * @return
     */
    public int calculate(int[] nums, int index, boolean up) {
        int ans = 0;
        for (int i = index + 1; i < nums.length; i++) {
            //判断index位置元素和下一个up位置元素是否可以构成摆动序列
            if ((up && nums[i] > nums[index]) || (!up && nums[i] < nums[index])) {
                ans = Math.max(ans, calculate(nums, i, !up)); //这里下一个一定与此相反
            }
        }
        return ans;
    }

    /**
     *   解法二：动态规划
     *      up[i]  代表第i个元素结尾的上升的最长摆动序列元素的个数
     *      down[j]  代表第j个元素结尾的下降的最长摆动序列的元素个数
     *        对于更新up[i]  是只需要判断down[j] > nums[i] (i > j) 成立则更新
     *        状态转移方程 up[i] = Math.max(up[i], 1+down[j])
     *        同理更新down[j]也是如此
     */
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        //创建俩个数组
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        //这里可以理解i控制数组长度,
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], 1 + down[j]);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], 1 + up[j]);
                }
            }
        }
        return 1 + Math.max(up[nums.length - 1], down[nums.length - 1]);
    }

    /**
     *   动态规划三：
     *       当nums[i] > nums[i-1] 时，up[i] = 1 + down[i-1], up[i] = up[i-1]
     *       当nums[i] < nums[i-1] 时，down[i] = 1 + up[i-1], down[i] = down[i-1]
     *       当nums[i] == nums[i-1] 时, up[i] = up[i-1], down[i] = down[i-1]
     *
     */
    public int wiggleMaxLength3(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        //创建俩个数组
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        //初始化,代表第0个元素摆动序列长度为1
        up[0] = 1;
        down[0] = 1;
        //动态规划计算
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                up[i] = 1 + down[i-1];
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {
                down[i] = 1 + up[i-1];
                up[i] = up[i-1];
            } else {
                up[i] = up[i-1];
                down[i] = up[i-1];
            }
        }

        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }

    /**
     *   优化空间复杂度
     */
    public int wiggleMaxLength4(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                up = 1 + down;
            } else if (nums[i] < nums[i-1]) {
                down = 1 + up;
            }
        }
        return Math.max(up, down);
    }

    /**
     *   贪心算法：
     *       首先需要一个维护变量preDiff表示当前序列是上升的还是下降的
     */
    public int wiggleMaxLength5(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int preDiff = nums[1] - nums[0];
        int count = preDiff != 0 ? 2 : 1;
        //使用贪心算法求解
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            //判断是上一个上升序列还是下降
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                count++;
                preDiff = diff;
            }
        }

        return count;
    }

}
