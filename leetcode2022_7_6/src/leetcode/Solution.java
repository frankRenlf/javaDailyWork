package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_7_6
 * @Package : leetcode
 * @createTime : 2022/7/6 10:45
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        left[0] = height[0];
        int[] right = new int[len];
        right[len - 1] = height[len - 1];
        for (int i = 1, j = len - 2; i < len; i++, j--) {
            left[i] = Math.max(left[i - 1], height[i]);
            right[j] = Math.max(right[j + 1], height[j]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }

}
