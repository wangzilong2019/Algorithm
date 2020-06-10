package leetcode.algorithm.array;

public class MaxProfit714 {
    /**
     *   动态规划问题：
     *      cash:表示当前不持有股票的最大利润
     *      hold：表示当前持有股票的最大利润
     *
     * */
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        //初始化
        int cash = 0;
        int hold = -prices[0];

        for (int i = 0; i < prices.length; i++) {
            //不持入股票的最大利润：当前不持入股票  持入股票专卖之后的最大利润
            cash = Math.max(cash, hold + prices[i] - fee);
            //持入购票的最大利润：当前持入的股票  为持入现在购买的
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
