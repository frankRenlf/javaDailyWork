package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_29
 * @Package : leetcode
 * @createTime : 2022/6/29 9:46
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    private Map<Integer, String> map = new HashMap<>();
    private int id;

    public String encode(String longUrl) {
        id++;
        map.put(id, longUrl);
        return "https://tinyurl.com/" + id;
    }

    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return map.get(key);
    }


    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;

        for (int i = 3; i <= n; i++) {
            int cur = f0 + f1;
            f0 = f1;
            f1 = cur;
        }
        return f1;
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if(len==1){
            return nums[0];
        }
        int f0 = nums[0];
        int f1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int cur = Math.max(f0 + nums[i], f1);
            f0 = f1;
            f1 = cur;
        }
        return f1;
    }


}
