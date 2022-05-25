package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_5_23
 * @Package : leetcode
 * @createTime : 2022/5/23 14:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30">...</a>
 * @Description :
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    List<Integer> l = new ArrayList<>();

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        l.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return l;
    }

    public boolean key = true;

    public void preOrder(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) {
            return;
        } else if (rootA != null && rootB != null) {
            if (rootA.val == rootB.val) {
                preOrder(rootA.left, rootB.left);
                preOrder(rootA.right, rootB.right);
            } else {
                key = false;
            }
        } else {
            key = false;
            return;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        preOrder(p, q);
        return key;
    }

}
