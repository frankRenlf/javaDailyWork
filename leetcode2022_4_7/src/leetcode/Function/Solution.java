package leetcode.Function;

public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < len; i++) {
            int ref0 = Math.max(f0, f2 - prices[i]);
            int ref1 = f0 + prices[i];
            int ref2 = Math.max(f1, f2);
            f0 = ref0;
            f1 = ref1;
            f2 = ref2;
        }
        return Math.max(f1, f2);
    }

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < len; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

}
