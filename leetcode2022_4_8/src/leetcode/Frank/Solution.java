package leetcode.Frank;

public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < len; i++) {
            int rec_f0 = Math.max(f0, f2 - prices[i]);
            int rec_f1 = f0 + prices[i];
            int rec_f2 = Math.max(f2, f1);
            f0 = rec_f0;
            f1 = rec_f1;
            f2 = rec_f2;
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
            buy = Math.max(sell, buy + prices[i] - fee);
        }
        return sell;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int d = nums[1] - nums[0];
        int t = 0;
        int ret = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == d) {
                t++;
            } else {
                d = nums[i] - nums[i - 1];
                t = 0;
            }
            ret += t;
        }
        return ret;
    }

    public boolean rotateString(String s, String goal) {
        return s.length()==goal.length()&&(s+s).contains(goal);
    }

}
