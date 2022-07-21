package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_7_20
 * @Package : leetcode
 * @createTime : 2022/7/20 15:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int step = k % (row * col);
        int[][] tmp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tmp[(i + (j + step) / col) % row][(j + step % col) % col] = grid[i][j];
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> elem = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                elem.add(tmp[i][j]);
            }
            ret.add(elem);
        }
        return ret;
    }

    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int step = k % (row * col);
        int row1 = step / col;
        int col1 = step % col;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> elem = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                elem.add(grid[(row1 + i + (col1 + j) / col) % row][(col1 + j) % col]);
            }
            ret.add(elem);
        }
        return ret;
    }


    public TreeNode pruneTree(TreeNode root) {
        TreeNode ret = root;
        rec(root);
        return ret;
    }

    private boolean rec(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        if (!rec(root.left)) {
            root.left = null;
        }
        if (!rec(root.right)) {
            root.right = null;
        }
        return rec(root.left) || rec(root.right);
    }

    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

}
