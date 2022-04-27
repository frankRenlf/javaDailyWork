package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int minCost = 0;
        int cur = 0;
        int pre = 0;
        for (int i = 2; i <= len; i++) {
            int tmp = cur;
            cur = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = tmp;
        }
        return cur;
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> rowOne = new ArrayList<>();
        rowOne.add(1);
        arr.add(rowOne);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j));
            }
            row.add(1);
            arr.add(row);
        }
        return arr;
    }

    public List<Character> test(String s1, String s2) {
        List<Character> ret = new ArrayList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s2.toCharArray()) {
            hm.put(c, 1);
        }
        for (char c : s1.toCharArray()) {
            if (hm.get(c) == null) {
                ret.add(c);
            }
        }
        return ret;
    }

    public static int obtain(int[] nums, int l, int r) {
        int pre = nums[l];
        int cur = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i < r; i++) {
            int tmp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = tmp;
        }
        return cur;
    }

    public int rob2(int[] num) {
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return num[0];
        }
        if (len == 2) {
            return Math.max(num[0], num[1]);
        }
        return Math.max(obtain(num, 0, len - 1), obtain(num, 1, len));
    }

}
