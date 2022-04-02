package leetcode.danamic;

public class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int sum = 0;
        int maxSum = A[0];
        int minSum = A[0];
        int curMax = 0;
        int curMin = 0;
        for (int x : A) {
            curMax = Math.max(x + curMax, x);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(x + curMin, x);
            minSum = Math.min(minSum, curMin);
            sum += x;
        }
        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }
}
