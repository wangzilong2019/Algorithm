package bit.algorithm.greed;

public class L55CanJump {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     */
    /**
     *  贪心算法：
     *  首先判断当前位置是否可到达
     *  若可到达，则在当前位置之前的可到达的最大位置，判断此位置是否可以到达终点
     *   若当前位置不可以到达，则直接返回false
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        //定义可到达的最大位置
        int max = 0;
        int pos = nums.length - 1;

        for (int i = 0; i <= pos; i++) {
            //判断当前位置是否可到达
            if (max >= i) {
                //更新max位置之前的可到达的最远位置
                max = Math.max(max, i + nums[i]);
                //判断是否可达
                if (max >= pos) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
