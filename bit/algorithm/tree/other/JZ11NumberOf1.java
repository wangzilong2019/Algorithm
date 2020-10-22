package bit.algorithm.other;

public class JZ11NumberOf1 {
    /**
     *  检测一个数字表示为二进制1的个数
     *   1011 1100
     *   1011 1011
     *   相等于到最后一个非零数字反转这样相等于提取0然后胡计算
     *
     *   这里注意  n & (n - 1)  得到的结果是将二进制表示的n的最右面为1的数为变为0
     *   即只要依次操作即可得到1的个数
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
