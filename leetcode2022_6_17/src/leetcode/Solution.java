package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_17
 * @Package : leetcode
 * @createTime : 2022/6/17 13:02
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }


    Map<Integer, Integer> map = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (map.containsKey(k - root.val)) {
            return true;
        }
        map.put(root.val, root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ret = root;
        while (root != null) {
            if (root.val > val) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new TreeNode(val);
                    break;
                }
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new TreeNode(val);
                    break;
                }
            }
        }
        if (ret == null) {
            ret = new TreeNode(val);
        }
        return ret;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                break;
            }
            root = root.val < val ? root = root.right : root.left;
        }
        return root;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }
}
