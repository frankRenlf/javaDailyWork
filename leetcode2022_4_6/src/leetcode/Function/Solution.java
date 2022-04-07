package leetcode.Function;

public class Solution {

    public int getMaxLen(int[] nums) {
        int length = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int max = positive;
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                int newPositive = negative > 0 ? negative + 1 : 0;
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            } else {
                positive = 0;
                negative = 0;
            }
            max = Math.max(max, positive);
        }
        return max;
    }


    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int pre = values[0];
        int max = values[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, pre + values[i] - i);
            pre = Math.max(pre, values[i] + i);
        }
        return max;
    }
}
