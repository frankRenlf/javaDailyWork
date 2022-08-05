package august5;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : august5
 * @createTime : 2022/8/5 15:07
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null && depth != 1) {
            return null;
        }
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < depth - 1; i++) {
            int size = queue.size();
            while (size > 0) {
                TreeNode parent = queue.poll();
                if (parent.left != null) {
                    queue.offer(parent.left);
                }
                if (parent.right != null) {
                    queue.offer(parent.right);
                }
                size--;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            cur.left = new TreeNode(val, cur.left, null);
            cur.right = new TreeNode(val, null, cur.right);
        }
        return root;
    }

}
