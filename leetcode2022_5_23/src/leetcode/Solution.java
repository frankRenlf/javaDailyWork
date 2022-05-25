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

    public boolean isSameTreePro(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            System.out.println(tmp.val);
        }
    }

//    public boolean isSubtree2(TreeNode s, TreeNode t) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(s);
//        isSameTreePro(s,t);
//        while (!queue.isEmpty()) {
//            TreeNode tmp = queue.poll();
//            if(tmp!=null){
//                isSameTreePro(tmp,t);
//            }
//            if (tmp.left != null) {
//                queue.add(tmp.left);
//            }
//            if (tmp.right != null) {
//                queue.add(tmp.right);
//            }
//            System.out.println(tmp.val);
//        }
//    }



}
