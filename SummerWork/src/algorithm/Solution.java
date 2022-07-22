package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : algorithm
 * @createTime : 2022/7/22 12:26
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public boolean judge(String str) {
        // write code here
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public int sqrt(int x) {
        // write code here
        int start = 0;
        int end = x / 2 + 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return start;
    }

    public String truncateSentence(String s, int k) {
        String[] tmp = s.split(" ");
        String ret = "";
        for (int i = 0; i < k; i++) {
            ret += tmp[i];
            if (i != k - 1) {
                ret += " ";
            }
        }
        return ret;
    }

    public int removeDuplicates(int[] nums) {
        int end = nums.length - 1;
        int k = end;
        int start = 0;
        while (start <= k) {
            int tmp = start + 1;
            while (nums[start] == nums[tmp]) {
                tmp++;
            }
            for (int i = start + 1, j = tmp; j < end; i++, j++) {
                nums[i] = nums[j];
                k = i;
            }
            start++;
        }
        return k + 1;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

}
