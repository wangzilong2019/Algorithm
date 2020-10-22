package bit.algorithm.other;

public class JZ12Power {
    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * 保证base和exponent不同时为0
     */
    /**
     *  解题思路： 运用快速幂
     *     本题注意事项，值数exponent 为负数时要考虑
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {

        //判断是正数还是负数
        boolean flag = exponent > 0 ? true : false;
        exponent = Math.abs(exponent);
        if (exponent == 0 || Math.abs(base - 1) < 1e-7) {
            return 1;
        }

        double ans = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                ans = ans * base;
            }
            base = base * base;
            exponent >>= 1;
        }
        return flag == true ? ans : 1 / ans;
    }
}
