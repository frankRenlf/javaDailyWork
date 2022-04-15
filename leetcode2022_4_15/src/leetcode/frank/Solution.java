package leetcode.frank;

public class Solution {

    public int arrangeCoins(int n) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if ((mid + 1) > (2 * n) / mid) {
                r = mid - 1;
            } else if ((mid + 1) == (2 * n) / mid) {
                return mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int[] dp = new int[len];
        int ret = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }

        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;
        int ret = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] == nums[i - 1]) {
                down[i] = down[i - 1];
                up[i] = up[i - 1];

            } else {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            }

        }
        return Math.max(up[len - 1], down[len - 1]);
    }

    public int wiggleMaxLength2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            }
        }
        return Math.max(up, down);
    }

}
