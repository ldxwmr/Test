package org.example.arr;

/**
 * @Author ldxwmr
 * @Date 2021/12/24 14:14
 */
public class 买股票的最佳时机 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        // 初始条件
        int hold = -prices[0];// 持有股票
        int noHold = 0;// 未持有股票
        for (int i = 0; i < length; i++) {
            // 递推公式转化的
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        // 最后一天肯定是手里没有股票的时候利润才会最大，所以这里返回的是noHold
        return noHold;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
