package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_28
 * @Package : leetcode
 * @createTime : 2022/6/28 10:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = f0 + f1;
            f0 = f1;
            f1 = cur;
        }
        return f1;
    }

    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        for (int i = 3; i <= n; i++) {
            int cur = f0 + f1 + f2;
            f0 = f1;
            f1 = f2;
            f2 = cur;
        }
        return f2;
    }
}
