package bit.algorithm.dp;

public class JZ10RectCover {
    /**
     * 动态规划：
     *      f[n] 代表填充2*n的矩阵可以放置2*1的矩阵的个数
     *      最后的一个矩阵可以竖着放、最后俩个矩阵可以横着放、即
     *      f[n] = f[n-1] + f[n-2];
     * @param target
     * @return
     */
    public int RectCover(int target) {
    if (target <= 1) {
        return 1;
    }else if (target == 2) {
        return 2;
    } else {
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
}
