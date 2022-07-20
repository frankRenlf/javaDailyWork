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
                tmp[(i + step / col) % row][(j + step % col) % col] = grid[i][j];
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
        int[][] ret = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret[i + k / col][j + k % col] = grid[i][j];
            }
        }
        return
    }

}
