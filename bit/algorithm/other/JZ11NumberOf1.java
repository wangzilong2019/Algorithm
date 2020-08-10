package bit.algorithm.other;

public class JZ11NumberOf1 {
    /**
     *  检测一个数字表示为二进制1的个数
     *   1011 1100
     *   1011 1011
     *   相等于到最后一个非零数字反转这样相等于提取0然后胡计算
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
