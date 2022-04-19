package leetcode;


import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {

            int ts = numbers[l] + numbers[r];
            if (ts == target) {
                return new int[]{l, r};
            } else if (ts > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1};
    }

}
