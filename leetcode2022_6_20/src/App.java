import leetcode.Solution;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_20
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/20 10:56
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class App {
    static Solution sol = new Solution();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static void main2(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static void main1(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindromeSubseq("bbbab"));
    }

}
