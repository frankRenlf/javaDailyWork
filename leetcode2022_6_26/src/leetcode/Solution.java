package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_26
 * @Package : leetcode
 * @createTime : 2022/6/26 10:53
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public int minCost2(int[][] costs) {
        int num = costs.length;
        int len = costs[0].length;
        int[][] dp = new int[num][len];
        System.arraycopy(costs[0], 0, dp[0], 0, len);
        for (int i = 1; i < num; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % len], dp[i - 1][(j + 2) % 3]) + costs[i][j];
            }
        }
        int ret = dp[num - 1][0];
        for (int i = 1; i < len; i++) {
            ret = Math.min(ret, dp[num - 1][i]);
        }
        return ret;
    }

    public int minCost(int[][] costs) {
        int num = costs.length;
        int len = costs[0].length;
        int[][] dp = new int[num][len];
        System.arraycopy(costs[0], 0, dp[0], 0, len);
        for (int i = 1; i < num; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % len], dp[i - 1][(j + 2) % 3]) + costs[i][j];
            }
        }
        int ret = dp[num - 1][0];
        for (int i = 1; i < len; i++) {
            ret = Math.min(ret, dp[num - 1][i]);
        }
        return ret;
    }

}
