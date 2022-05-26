package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_5_26
 * @Package : leetcode
 * @createTime : 2022/5/26 18:17
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30">...</a>
 * @Description :
 */
public class Solution2 {

    int pi = 0;

    public void swap(int[] preorder) {
        int len = preorder.length;
        for (int i = 0, j = len - 1; i < len/2; i++, j--) {
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

        root.right = buildProcess(preorder, inorder, rootIndex + 1, ie);
        root.left = buildProcess(preorder, inorder, is, rootIndex - 1);

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

    public TreeNode buildTree(int[] inorder,int[] preorder) {
        swap(preorder);
        return buildProcess(preorder, inorder, 0, inorder.length - 1);
    }

}
