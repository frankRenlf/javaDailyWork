package summerWork.july.july28;

import structure.ListNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : summerWork.july.july28
 * @createTime : 2022/7/28 11:08
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    // it also needs to judge the null type
    // it requires an empty array
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        map.put(arr[0], index);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                index++;
            }
            map.put(arr[i], index);
        }
        int[] ret = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            ret[i] = map.get(tmp[i]);
        }
        return ret;
    }

    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        writeValue(head);
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    private void writeValue(ListNode root) {
        if (root == null) {
            return;
        }
        writeValue(root.next);
        list.add(root.val);
    }


    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode cur = head;
        while (cur.next != null) {
            //Returns:
            //true if this set did not already contain the specified element
            if (!set.add(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
