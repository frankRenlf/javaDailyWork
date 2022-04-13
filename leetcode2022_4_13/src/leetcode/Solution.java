package leetcode;

public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int l = 1;
        int r = x / 2;
        while (l <= r) {
            int mid = l + ((r - l + 1) >>> 1);
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length;
        int n = r;
        while (l < r) {
            int mid = l + ((r - l) >>> 1);
            if (letters[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[r % n];
    }

}