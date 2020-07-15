package leetcode.algorithm.dp;

public class MinSteps {
    /**
     *   动态规划：
     *      当n为质数时，最小操作次数即为数字本身
     *      当n为合数时，最小操作次数为分解质数之和
     */
    public int minSteps(int n) {
        int ans = 0;
        int d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
