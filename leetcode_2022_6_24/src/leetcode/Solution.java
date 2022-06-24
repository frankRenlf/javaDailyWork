package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode_2022_6_24
 * @Package : leetcode
 * @createTime : 2022/6/24 10:00
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */


public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int maxVal = Integer.MIN_VALUE;
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                maxVal = Math.max(maxVal, cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                size--;
            }
            ret.add(maxVal);
        }
        return ret;
    }


}
