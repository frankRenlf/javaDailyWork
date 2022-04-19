import leetcode.Solution;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5};
        int t = 6;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(arr, t)));
    }

}
