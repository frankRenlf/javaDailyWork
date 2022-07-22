package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_7_20
 * @Package : leetcode
 * @createTime : 2022/7/20 15:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int step = k % (row * col);
        int[][] tmp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tmp[(i + (j + step) / col) % row][(j + step % col) % col] = grid[i][j];
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> elem = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                elem.add(tmp[i][j]);
            }
            ret.add(elem);
        }
        return ret;
    }

    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int step = k % (row * col);
        int row1 = step / col;
        int col1 = step % col;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> elem = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                elem.add(grid[(row1 + i + (col1 + j) / col) % row][(col1 + j) % col]);
            }
            ret.add(elem);
        }
        return ret;
    }


    public TreeNode pruneTree(TreeNode root) {
        TreeNode ret = root;
        rec(root);
        return ret;
    }

    private boolean rec(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        if (!rec(root.left)) {
            root.left = null;
        }
        if (!rec(root.right)) {
            root.right = null;
        }
        return rec(root.left) || rec(root.right);
    }

    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int x : nums1) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
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

}
