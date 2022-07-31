package july31;

import structure.ListNode;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : july31
 * @createTime : 2022/7/31 14:21
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return pre.next;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode pre = new ListNode(0);
        pre.next = pHead;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;
                cur.next = cur.next.next.next;
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int ret = level;
        int maxSum = root.val;
        while (!queue.isEmpty()) {
            int count = queue.size();
            int sum = 0;
            while (count > 0) {
                TreeNode parent = queue.poll();
                sum += parent.val;
                if (parent.left != null) {
                    queue.offer(parent.left);
                }
                if (parent.right != null) {
                    queue.offer(parent.right);
                }
                count--;
            }
            if (sum > maxSum) {
                ret = level;
                maxSum = sum;
            }
            level++;
        }
        return ret;
    }

}
