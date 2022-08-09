package summerWork.august.august2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : summerWork.august.august2
 * @createTime : 2022/8/2 16:12
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Solution {

    // 大小写没整对
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1, index = 0; i <= n && index < target.length; i++) {
            if (target[index] == i) {
                list.add("Push");
                index++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int val = nums2[i];
            while (!stack.isEmpty() && val >= stack.peek()) {
                stack.pop();
            }
            map.put(val, stack.isEmpty() ? -1 : stack.peek());
            stack.push(val);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

}
