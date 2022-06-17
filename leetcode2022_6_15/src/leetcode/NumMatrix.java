package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_15
 * @Package : leetcode
 * @createTime : 2022/6/17 10:51
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class NumMatrix {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = get_dp(mat, m, n);
        return get_res(dp, m, n, k);
    }

    //获取dp数组
    public int[][] get_dp(int[][] arr, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] + arr[i][j] - dp[i][j];
        return dp;
    }

    //获取结果
    public int[][] get_res(int[][] dp, int m, int n, int k) {
        int[][] res = new int[m][n];
        int x1, y1, x2, y2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x1 = Math.max(0, i - k);
                y1 = Math.max(0, j - k);
                x2 = Math.min(m, i + k + 1);
                y2 = Math.min(n, j + k + 1);
                res[i][j] = dp[x2][y2] - dp[x1][y2] - dp[x2][y1] + dp[x1][y1];
            }
        }
        return res;
    }

    //method 2
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
