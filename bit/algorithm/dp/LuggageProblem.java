package bit.algorithm.dp;

public class LuggageProblem {
    /**
     * 0-1背包问题
     */
    public int luggage(int m, int[] a, int[] v) {
        if (a == null || a.length == 0 || v == null || v.length == 0) {
            return -1;
        }
        //记录商品个数
        int n = a.length;
        //创建一个二维数组
        int[][] value = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //判断当前商品价值能不能放入背包中
                if (a[i-1] <= j) {
                    value[i][j] = Math.max(value[i-1][j] , value[i-1][j - a[i-1]] + v[i-1]) ;
                } else {
                    value[i][j] = value[i-1][j];
                }
            }
        }
        return value[n][m];
    }

    /**
     * 动态规划：优化
     * 这里注意要从后往前更新值
     * @param m
     * @param a
     * @param v
     * @return
     */
    public int luggage2(int m, int[] a, int[] v) {
        if (a == null || a.length == 0 || v == null || v.length == 0) {
            return -1;
        }
        //记录商品个数
        int n = a.length;
        //创建一个一维数组
        int[] value = new int[m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j > 0; j--) {
                //判断当前商品价值能不能放入背包中
                if (a[i-1] <= j) {
                    value[j] = Math.max(value[j] , value[j - a[i-1]] + v[i-1]) ;
                }
            }
        }
        return value[m];
    }
}
