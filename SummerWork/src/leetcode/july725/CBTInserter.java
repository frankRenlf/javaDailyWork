package leetcode.july725;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : leetcode.july725
 * @createTime : 2022/7/25 14:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        tmp.add(root);
        while (!tmp.isEmpty()) {
            TreeNode cur = tmp.poll();
            if (cur.left != null) {
                tmp.offer(cur.left);
            }
            if (cur.right != null) {
                tmp.offer(cur.right);
            }
            if (cur.left == null || cur.right == null) {
                queue.offer(cur);
            }
        }
    }

    public int insert(int val) {
        TreeNode child = new TreeNode(val);
        TreeNode parent = queue.peek();
        if (parent.left == null) {
            parent.left = child;
        } else {
            parent.right = child;
            queue.poll();
        }
        queue.add(child);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
