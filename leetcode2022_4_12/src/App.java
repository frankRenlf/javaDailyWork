import leetcode.Frank.Solution;

public class App {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(sol.minPathSum(arr));
    }

}
