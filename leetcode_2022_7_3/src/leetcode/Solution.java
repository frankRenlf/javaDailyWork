package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode_2022_7_3
 * @Package : leetcode
 * @createTime : 2022/7/3 13:28
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (min > diff) {
                min = diff;
                ret.clear();
                List<Integer> elem = new ArrayList<>();
                elem.add(arr[i]);
                elem.add(arr[i + 1]);
                ret.add(elem);
            } else if (min == diff) {
                List<Integer> elem = new ArrayList<>();
                elem.add(arr[i]);
                elem.add(arr[i + 1]);
                ret.add(elem);
            }
        }
        return ret;
    }

    public int jump(int[] nums) {
        int len = nums.length;
        int count = 0;
        int maxLen = 0;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            if (cur < i) {
                count++;
                cur = maxLen;
            }
            maxLen = Math.max(nums[i] + i, maxLen);
        }
        return count;
    }

    public boolean canJump(int[] nums) {
        int maxLen = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (maxLen >= i) {
                maxLen = Math.max(nums[i] + i, maxLen);
            } else {
                return false;
            }
        }
        return true;
    }


    public int deleteAndEarn(int[] nums) {
        int minVal = nums[0];
        int maxVal = nums[0];
        for (int x : nums) {
            minVal = Math.min(x, minVal);
            maxVal = Math.max(maxVal, x);
        }
        int[] sum = new int[maxVal - minVal + 1];
        for (int num : nums) {
            sum[num - minVal] += num;
        }
        return rob(sum);
    }

}
