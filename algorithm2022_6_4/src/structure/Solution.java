package structure;

import java.util.*;

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

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (pre.val == cur.val) {
                pre.next = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode ph = new ListNode(0);
        ph.next = head;
        ListNode pre = ph;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }

        }
        return ph.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        int sl = s.length(), tl = t.length();
        if (sl != tl) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < sl; i++) {
            arr[s.charAt(i) - 97]++;
            arr[t.charAt(i) - 97]--;
        }
        for (int x : arr) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char tmp = magazine.charAt(i);
            hashMap.put(tmp, hashMap.getOrDefault(tmp, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char tmp = ransomNote.charAt(i);
            if (hashMap.containsKey(tmp)) {
                int val = hashMap.get(tmp);
                if (val > 0) {
                    hashMap.replace(tmp, val - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subBoxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subBoxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subBoxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(list);
        }
        return ret;
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

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
