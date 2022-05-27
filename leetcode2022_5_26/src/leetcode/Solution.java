package leetcode;

import com.sun.source.tree.Tree;

import java.util.*;


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

//    public Stack<Integer> stack1;
//    public Stack<Integer> stack2;

    int index = 0;

    public TreeNode createTree(String dest) {
        // 根 左子树 右子树
        TreeNode root = new TreeNode(dest.charAt(index));
        index++;
        if (dest.charAt(index) != '#') root.left = createTree(dest);
        index++;
        if (dest.charAt(index) != '#') root.right = createTree(dest);
        return root;
    }

    public void InfixOrder(TreeNode root) {
        if (root == null) return;
        InfixOrder(root.left);
        System.out.print(root.val + " ");
        InfixOrder(root.right);
    }

    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null || node == null) {
            return false;
        }
        stack.push(root);
        if (root == node) {
            return true;
        }
        boolean key = getPath(root.left, node, stack);
        if (key) {
            return true;
        }
        key = getPath(root.right, node, stack);
        if (key) {
            return true;
        }
        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        getPath(root, p, stack1);
        Stack<TreeNode> stack2 = new Stack<>();
        getPath(root, q, stack2);
        int diff = stack1.size() - stack2.size();
        while (diff > 0) {
            diff--;
            stack1.pop();
        }
        while (diff < 0) {
            diff++;
            stack2.pop();
        }
        while (stack1.size() > 0) {
            TreeNode cur = stack1.pop();
            if (Objects.equals(cur, stack2.pop())) {
                return cur;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor2(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode != null) {
            return leftNode;
        } else return rightNode;
    }


    TreeNode pre = null;

    public void inOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        p.left = pre;
        if (pre != null) {
            pre.right = p;
        }
        pre = p;

        inOrder(p.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inOrder(pRootOfTree);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    int pi = 0;

    public void swap(int[] preorder) {
        int len = preorder.length;
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            int tmp = preorder[i];
            preorder[i] = preorder[j];
            preorder[j] = tmp;
        }
    }

    public TreeNode buildProcess(int[] preorder, int[] inorder, int is, int ie) {
        if (is > ie) return null;

        TreeNode root = new TreeNode(preorder[pi]);

        int rootIndex = findInorderIndex(inorder, is, ie, preorder[pi]);
        pi++;
        if (rootIndex == -1) {
            return null;
        }
        root.left = buildProcess(preorder, inorder, is, rootIndex - 1);
        root.right = buildProcess(preorder, inorder, rootIndex + 1, ie);

        return root;
    }

    private int findInorderIndex(int[] inorder, int is, int ie, int val) {
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1; // no such val
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        swap(preorder);
        return buildProcess(preorder, inorder, 0, inorder.length - 1);
    }


    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer()
                    .append(root.val)
                    .append("(")
                    .append(tree2str(root.left))
                    .append(")").toString();
        }
        return new StringBuffer()
                .append(root.val)
                .append("(")
                .append(tree2str(root.left))
                .append(")(")
                .append(tree2str(root.right))
                .append(")").toString();
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                ret.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return ret;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode tmp = stack.pop();
            ret.add(tmp.val);
            cur = tmp.right;
        }
        return ret;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                ret.addFirst(root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return ret;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == pre) {
                ret.add(stack.pop().val);
                pre = top;
            } else {
                cur = top.right;
            }
        }

        return ret;
    }

}
