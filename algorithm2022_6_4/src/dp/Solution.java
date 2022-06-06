package dp;

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

    public int maxProfit(int[] prices) {
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

    public int maxSubArray(int[] nums) {
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
