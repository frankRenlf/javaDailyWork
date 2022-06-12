package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : algorithm2022_6_4
 * @Package : structure
 * @createTime : 2022/6/4 12:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public int maxProfit(int[] prices, int fee) {
        int dp0 = -prices[0];
        int dp1 = 0;
        for (int i = 1; i < prices.length; i++) {
            dp1 = Math.max(dp1, dp0 + prices[i] - fee);
            dp0 = Math.max(dp0, dp1 - prices[i]);
        }
        return dp1;
    }

    public int maxProfit5(int[] prices) {
        int dp0 = -prices[0];
        int dp1 = 0;//in
        int dp2 = 0;//out
        for (int i = 1; i < prices.length; i++) {
            int nd0 = Math.max(dp0, dp2 - prices[i]);
            int nd1 = nd0 + prices[i];
            int nd2 = Math.max(dp1, dp2);
            dp0 = nd0;
            dp1 = nd1;
            dp2 = nd2;
        }
        return Math.max(dp1, dp2);
    }

    public int maxProfit4(int[] prices) {
        int len = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < len; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

    public int maxProfit3(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }


    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int mx = 0;
        for (int i = 1; i < len; i++) {
            mx = Math.max(mx, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return mx;
    }

    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = values[0];
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }

    public int getMaxLen(int[] nums) {
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int max = positive;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive += 1;
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                int tp = negative > 0 ? negative + 1 : 0;
                int tn = positive + 1;
                positive = tp;
                negative = tn;
            } else {
                positive = 0;
                negative = 0;
            }
            max = Math.max(max, positive);
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int preMin = nums[0];
        int preMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            int mn = preMin, mx = preMax;
            preMin = Math.min(mn * nums[i], Math.min(mx * nums[i], nums[i]));
            preMax = Math.max(mx * nums[i], Math.max(nums[i], nums[i] * mn));
            max = Math.max(max, preMax);
        }
        return max;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int preMax = nums[0];
        int max = nums[0];
        int preMin = nums[0];
        int min = nums[0];
        int total = nums[0];
        for (int i = 1; i < len; i++) {
            total += nums[i];
            preMax = Math.max(preMax + nums[i], nums[i]);
            max = Math.max(max, preMax);
            preMin = Math.min(preMin + nums[i], nums[i]);
            min = Math.min(preMin, min);
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (pre + nums[i] >= nums[i]) {
                pre += nums[i];
            } else {
                pre = nums[i];
            }
            max = Math.max(max, pre);
        }
        return max;
    }

    public int jump(int[] nums) {
        int len = nums.length;
        int rightMost = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; end < len - 1; i++) {
            rightMost = Math.max(rightMost, i + nums[i]);
            if (i == end) {
                end = rightMost;
                step++;
            }
        }
        return step;
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int most = 0;
        for (int i = 0; i < len; i++) {
            if (i <= most) {
                most = Math.max(most, i + nums[i]);
                if (most >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxProfit1(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            int tmp = cur;
            cur += pre;
            pre = tmp;
        }
        return cur;
    }

    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 2; i < n; i++) {
            int tmp = c;
            c += a + b;
            a = b;
            b = tmp;
        }
        return c;
    }

    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }


    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 1;
        int cur = 2;
        int mx = 2;
        for (int i = 2; i < n; i++) {
            mx = pre + cur;
            pre = cur;
            cur = mx;
        }
        return mx;
    }

    public int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;
        if (len == 1) {
            return cost[0];
        }
        int pre = cost[0];
        int cur = cost[1];
        int mn = 0;
        for (int i = 2; i < len; i++) {
            mn = Math.min(pre + cost[i], cur + cost[i]);
            pre = cur;
            cur = mn;
        }
        return Math.min(pre, cur);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int len = cost.length;
        int pre = 0;
        int cur = 0;
        int next = 0;
        for (int i = 2; i <= len; i++) {
            next = Math.min(pre + cost[i - 2], cur + cost[i - 1]);
            pre = cur;
            cur = next;
        }
        return next;
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(pre, nums[1]);
        int next = cur;
        for (int i = 2; i < len; i++) {
            next = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = next;
        }
        return next;
    }

    private int cal(int[] nums, int s, int e) {
        if (e - s == 0) {
            return nums[s];
        }
        int pre = nums[s];
        int cur = Math.max(pre, nums[s + 1]);
        int next = cur;
        for (int i = s + 2; i <= e; i++) {
            next = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = next;
        }
        return next;
    }

    public int rob2(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(cal(nums, 0, len - 2), cal(nums, 1, len - 1));
    }

    public int deleteAndEarn(int[] nums) {
        int minVal = nums[0];
        int maxVal = nums[0];
        for (int x : nums) {
            minVal = Math.min(x, minVal);
            maxVal = Math.max(maxVal, x);
        }
        int[] sum = new int[maxVal - minVal + 1];
        for (int num : nums) {
            sum[num - minVal] += num;
        }
        return rob(sum);
    }
}
