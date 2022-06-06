package structure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : algorithm2022_6_4
 * @Package : structure
 * @createTime : 2022/6/4 12:29
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int x : nums1) {
            if (!hashMap.containsKey(x)) {
                hashMap.put(x, 1);
            } else {
                hashMap.replace(x, hashMap.get(x) + 1);
            }
        }
        int[] ret = new int[nums1.length];
        int index = 0;
        for (int j : nums2) {
            if (hashMap.containsKey(j)) {
                hashMap.replace(j, hashMap.get(j) - 1);
                ret[index++] = j;
                if (hashMap.get(j) == 0) {
                    hashMap.remove(j);
                }
            }
        }
        return Arrays.copyOf(ret, index);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int x : nums) {
            if (!hashSet.add(x)) {
                return true;
            }
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return new int[2];
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int e1 = m - 1;
        int e2 = n - 1;
        int tail = m + n - 1;
        while (e1 >= 0 || e2 >= 0) {
            if (e1 < 0) {
                nums1[tail--] = nums2[e2--];
            } else if (e2 < 0) {
                break;
            } else if (nums1[e1] < nums2[e2]) {
                nums1[tail--] = nums2[e2--];
            } else {
                nums1[tail--] = nums1[e1--];
            }
        }
    }

}
