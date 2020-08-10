package bit.algorithm.dp;

public class JZ9JumpFloorII {
    /**
     *  动态规划：
     *      1、定义状态
     *      2、状态转移方程
     *      3、设置初始值
     */
    public int JumpFloorII(int target) {
        if (target == 1 || target == 2 ) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
    public int JumpFloorII2(int target) {
        return 1 << (target - 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(new JZ9JumpFloorII().JumpFloorII2(i));
        }
    }
}
