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

//速度还是很快的
public class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue;

    // 这个leetcode的时间复杂度还是有点问题的,一会块一会,慢. 估计和网速有关,或者他们运行代码的服务器拥挤问题.
    // 在这道题中,我用queue先将未填满的父节点都储存下来,这样虽然在initiate时需要耗费O(n),但是在后面多次插入时,只需要O(1),非常方便.
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        tmp.add(root);
        // 使用广度优先遍历,将最后两行的未填满的节点都存入queue中.
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

    //这样在insert时可以迅速插入,复杂度达到O(1).
    // 整体需要花费O(n)的额外空间
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
