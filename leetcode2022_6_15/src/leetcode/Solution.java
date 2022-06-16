package leetcode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_15
 * @Package : leetcode
 * @createTime : 2022/6/16 11:40
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        for (int r = 1; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r - 1][c];
                if (c > 0)
                    best = Math.min(best, A[r - 1][c - 1]);
                if (c + 1 < N)
                    best = Math.min(best, A[r - 1][c + 1]);
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : A[N - 1])
            ans = Math.min(ans, x);
        return ans;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j,
                        Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }

}
