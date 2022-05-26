package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_5_26
 * @Package : leetcode
 * @createTime : 2022/5/26 10:53
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30">...</a>
 * @Description :
 */
public class Solution {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public void preOrder(TreeNode root, TreeNode t) {
        if (root == null || root == t) {
            return;
        }
        preOrder(root.left, t);
        preOrder(root.right, t);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        preOrder(root,p);
    }
}
