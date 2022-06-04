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
}
