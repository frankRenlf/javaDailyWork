package july29;

import structure.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : july29
 * @createTime : 2022/7/29 11:05
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1, p2)) {
            return false;
        }
        if (help(p1, p2, p3, p4)) {
            return true;
        }
        if (Arrays.equals(p1, p3)) {
            return false;
        }
        if (help(p1, p3, p2, p4)) {
            return true;
        }
        if (Arrays.equals(p1, p4)) {
            return false;
        }
        if (help(p1, p4, p2, p3)) {
            return true;
        }
        return false;
    }

    public boolean help(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] v1 = {p1[0] - p2[0], p1[1] - p2[1]};
        int[] v2 = {p3[0] - p4[0], p3[1] - p4[1]};
        return checkMidPoint(p1, p2, p3, p4) && checkLength(v1, v2) && calCos(v1, v2);
    }

    public boolean checkLength(int[] v1, int[] v2) {
        return (v1[0] * v1[0] + v1[1] * v1[1]) == (v2[0] * v2[0] + v2[1] * v2[1]);
    }

    public boolean checkMidPoint(int[] p1, int[] p2, int[] p3, int[] p4) {
        return (p1[0] + p2[0]) == (p3[0] + p4[0]) && (p1[1] + p2[1]) == (p3[1] + p4[1]);
    }

    public boolean calCos(int[] v1, int[] v2) {
        return (v1[0] * v2[0] + v1[1] * v2[1]) == 0;
    }

    // 吃饭去了,想看代码,可以看一下, leetcode 题目网址: https://leetcode.cn/problems/add-two-numbers/submissions/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carryBit = 0;
        while (l1 != null && l2 != null) {
            int curVal = l1.val + l2.val + carryBit;
            cur.next = new ListNode((curVal) % 10);
            carryBit = curVal / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            int curVal = l1.val + carryBit;
            cur.next = new ListNode((curVal) % 10);
            carryBit = curVal / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            int curVal = l2.val + carryBit;
            cur.next = new ListNode((curVal) % 10);
            carryBit = curVal / 10;
            l2 = l2.next;
            cur = cur.next;
        }
        if (carryBit == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }


    // 回来了, 还剩一题
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode pre = new ListNode(0);
        pre.next = head;
        int sum = 0;
        for (ListNode cur = pre; cur != null; cur = cur.next) {
            sum += cur.val;
            map.put(sum, cur);
        }
        sum = 0;
        for (ListNode cur = pre; cur != null; cur = cur.next) {
            sum += cur.val;
            cur.next = map.get(sum).next;
        }
        return pre.next;
    }


}



