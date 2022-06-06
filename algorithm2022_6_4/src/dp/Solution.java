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
        if(len==1){
            return nums[0];
        }
        int pre = nums[0];
        int cur = Math.max(pre, nums[1]);
        int next = 0;
        for (int i = 2; i < len; i++) {
            next = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = next;
        }
        return next;
    }
}
