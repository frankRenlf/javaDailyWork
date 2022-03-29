import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (ht.containsKey(target - nums[i])) {
                return new int[]{ht.get(target - nums[i]), i};
            }
            ht.put(nums[i], i);
        }

        return new int[0];
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int maxSubArray(int[] ns) {
        int max = ns[0];
        int pre = 0;
        for (int x : ns) {
            pre += x;
            pre = Math.max(pre, x);
            max = Math.max(max, pre);
        }
        return max;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getCnt(answerKey, 'T', k), getCnt(answerKey, 'F', k));
    }

    public int getCnt(String s, char c, int k) {
        int n = s.length();
        int count = 0;
        int ret = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                count++;
            }
            while (count > k) {
                if (s.charAt(j) == c) {
                    count--;
                }
                j++;
            }
            ret = Math.max(ret, i - j + 1);
        }
        return ret;
    }

}

public class App {

    public static void main(String[] args) {
        String s = "TFFT";
        Solution sol = new Solution();
        System.out.println(sol.maxConsecutiveAnswers(s,1));
    }

    public static void main3(String[] args) {
        int[] arr = new int[]{1, 3, 5, 3, -10, 5};
        Solution sol = new Solution();
        System.out.println(sol.maxSubArray(arr));

    }

    public static void main2(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1, 3, 5, 7};
        int n = sol.searchInsert(arr, 2);
        System.out.println(n);
    }

    public static void main1(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1, 2, 3, 7, 15};
        System.out.println(Arrays.toString(sol.twoSum(arr, 16)));
    }
}
