package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_20
 * @Package : leetcode
 * @createTime : 2022/6/20 10:56
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int j = 0; j < len; j++) {
            dp[j][j] = 1;
            char c1 = s.charAt(j);
            for (int i = j - 1; i >= 0; i--) {
                if (c1 == s.charAt(i)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }


    // false test
    private static int count2(String s, int l, int r) {
        int len = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                len++;
                l--;
                r++;
            } else {

            }

        }
        return len;
    }

    private static int count(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int l1 = count(s, i, i);
            int l2 = count(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (l > end - start + 1) {
                end = i + l / 2;
                start = i - (l - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

}