import leetcode.frank.Solution;

import java.util.Arrays;

public class App {

    public static void main1(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countNumbersWithUniqueDigits(2));
    }

    public static void main2(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        sol.lengthOfLIS(arr);
    }

    public static void main3(String[] args) {
        Solution sol = new Solution();
        int[] widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String S = new String("bbbcccdddaaa");
        System.out.println(Arrays.toString(sol.numberOfLines(widths, S)));

    }

//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        System.out.println(sol.isPerfectSquare(16));
//    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3, 7));
    }

}
