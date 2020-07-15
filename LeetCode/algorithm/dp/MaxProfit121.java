package leetcode.algorithm.dp;

public class MaxProfit121 {
    /**
     *   股票的最大利润
     *   暴力解法：
     *      用二重循环求的当前元素和之前的最小值，记录最大差值的绝对值
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j]-prices[i];
                //判断是否要更新最优解
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    /**
     *   解法二
     *    分析可知，买入时最低，卖出时最高价格，即为最大利润
     *    因此只需要遍历找到最低价格，然后再判断是否为最优解
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MIN_VALUE;
        int maxProfit = 0;
        //遍历股票价格
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (prices[i]-minPrice > maxProfit) {
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(new MaxProfit121().maxProfit2(nums));
    }
}
