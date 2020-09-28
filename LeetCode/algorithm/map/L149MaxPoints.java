package leetcode.algorithm.map;

import java.math.BigInteger;

public class L149MaxPoints {
    /**
     * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
     */
    /**
     *  方法一：暴力解法
     *    已知任意俩点确定一条直线，可以任意选择俩点，求出直线方程，判断有多少个点在直线上
     *    y1 - y2 / x1- x2 == y - y1 / x - x1
     *    //此时若直接比较的哈浮点数可能会带来麻烦
     *       方式一：将除法等式转换为乘法等式，此时要求不能溢出，可以用大数字类
     *       方式二：对分字分母化简，通过比对分子分母的值来判断
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points == null || points.length < 3) {
            return points.length;
        }

        int i = 0;
        //判断是否是所有点都重回
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i+1][0] || points[i][1] != points[i+1][1]) {
                break;
            }
        }

        if (i == points.length - 1) {
            return points.length;
        }

        int max = 0;
        //三层循环，外俩层随机找俩个点
        for (int j = 0; j < points.length; j++) {
            for (int k = j + 1; k < points.length; k++) {
                //此俩个点不能重合
                if (points[j][0] == points[k][0] && points[j][1] == points[k][1]) {
                    continue;
                }
                int tempMax = 0;
                for (int m = 0; m < points.length; m++) {
                    //此点不能为前俩个点
                    if (m != k && m != j) {
                        if (test(points[j][0], points[j][1], points[k][0], points[k][1], points[m][0], points[m][1])) {
                            tempMax++;
                        }
                    }
                }

                if (tempMax > max) {
                    max = tempMax;
                }
            }
        }
        return max + 2;
    }

    /**
     * 判断此点是否在直线上
     *    方式一：将除法表达式转换为乘法表达式
     *            为了防止溢出此时要用大数类
     *    (y2-y1)*(x-x2) == (x2-x1)*(y-y2)
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x
     * @param y
     * @return
     */
    public boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        BigInteger x11 = BigInteger.valueOf(x1);
        BigInteger y11 = BigInteger.valueOf(y1);
        BigInteger x22 = BigInteger.valueOf(x2);
        BigInteger y22 = BigInteger.valueOf(y2);
        BigInteger x0 = BigInteger.valueOf(x);
        BigInteger y0 = BigInteger.valueOf(y);

        return y22.subtract(y11).multiply(x0.subtract(x22)).equals(x22.subtract(x11).multiply(y0.subtract(y22)));
    }

    /**
     * (y1 - y2) / (x1- x2) == (y - y1) / (x - x1)
     * 然后 test 函数就可以写成下边的样子。
     * 需要注意的是，我们求了y - y2 和 x - x2 最大公约数，所以要保证他俩都不是 0 ，防止除零错误。
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x
     * @param y
     * @return
     */
    public boolean test2(int x1, int y1, int x2, int y2, int x, int y) {
        int g1 = gcd(y1 - y2, x1 - x2);
        if (x == x1 && y == y1) {
            return true;
        }
        int g2 = gcd(y - y1, x - x1);
        return (y1 - y2) / g1 == (y - y1) / g2 && (x1 - x2) / g1 == (x - x1) / g2;
    }

    /**
     * 辗转相除法求俩个数的最大公约数
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
