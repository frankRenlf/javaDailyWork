package leetcode;

import java.util.Arrays;

public class Solution {

    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] ret = new int[len];
        Arrays.fill(ret, len);
        for (int i = 0, j = -1; i < len; i++) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != -1) {
                ret[i] = i - j;
            }
        }
        for (int i = len - 1, j = -1; i >= 0; i++) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != -1) {
                ret[i] = Math.min(ret[i], j - i);
            }
        }
        return ret;
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < len; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] ret = new int[len + 1];
        ret[0] = 1;
        return ret;
    }

    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }


}
