package bit.algorithm.dp;

public class LC19MinCut {
    /**
     * 给出一个字符串s，分割s使得分割出的每一个子串都是回文串
     * 计算将字符串s分割成回文分割结果的最小切割数
     * 例如:给定字符串s="aab",
     * 返回1，因为回文分割结果["aa","b"]是切割一次生成的。
     */
    /**
     * 状态f[i] 代表前i个字符的最小分割次数
     *    f[i] : j < i && (j+1, i) 是回文串 min(f[j] + 1)
     *    f[1] : 0
     *    f[2] :整体
     *    f[3] ; f[2] + 1 (aa | b)
     *
     *    长度为i的字符串最多分割i-1次
     * @param s string字符串
     * @return int整型
     */
    public int minCut (String s) {
        // write code here
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        //创建一个一维数组记录前i个字符最小的分割次数
        int[] minCut = new int[s.length() + 1];
        //初始化数组
        for (int i = 1; i <= s.length(); i++) {
            minCut[i] = i - 1;
        }
        //动态规划进行字符串分割
        //从前俩个字符开始
        for (int i = 2; i <= s.length(); i++) {
            //判断当前长度字符串是否为回文串
            if (isParm(s, 0, i-1)) {
                minCut[i] = 0;
                continue;
            }
            // j < i && j + 1,i 为回文串
            //这里从第一个字符开始
           for (int j = 1; j < i; j ++) {
                if (isParm(s, j, i-1)) {
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }
        return minCut[s.length()];
    }

    /**
     * 优化代码
     * @param s
     * @return
     */
    public int minCut2 (String s) {
        // write code here
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        //创建一个一维数组记录前i个字符最小的分割次数
        int[] minCut = new int[s.length() + 1];
        //初始化数组
        for (int i = 0; i <= s.length(); i++) {
            minCut[i] = i - 1;
        }
        //动态规划进行字符串分割
        //从前俩个字符开始
        for (int i = 2; i <= s.length(); i++) {

            // j < i && j + 1,i 为回文串
            //这里从第一个字符开始
            for (int j = 0; j < i; j ++) {
                if (isParm(s, j, i-1)) {
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }
        return minCut[s.length()];
    }

    /**
     * 判断一个字符串是否为回文串
     * @param start
     * @param end
     * @return
     */
    public boolean isParm(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     *动态规划判断是否为回文串
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean isParm2(String s, int start, int end) {
        //记录字符串长度
        int len = s.length();
        //创建一个数组记录字符串下标i,j是否为回文串
        boolean[][] isP = new boolean[len][len];
        for (int i = len - 1; i >= 0; i++) {
            for (int j = i; j < len; j++) {
                //记录下标
                if (i == j) {
                    isP[i][j] = true;
                } else if (j == i + 1) {
                    isP[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    isP[i][j] = (s.charAt(i) == s.charAt(j)) && isP[i+1][j-1];
                }
            }
        }
        return isP[start][end];
    }
}
