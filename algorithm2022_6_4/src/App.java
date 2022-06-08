import BinarySearch.Solution;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : algorithm2022_6_4
 * @Package : PACKAGE_NAME
 * @createTime : 2022/6/4 12:04
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class App {

    public static void main(String[] args) {
        dp.Solution sol = new dp.Solution();
        System.out.println(sol.maxSubarraySumCircular(new int[]{-1, 3, -5, 9}));
    }

    public static void main9(String[] args) {
        structure.Solution sol = new structure.Solution();
        System.out.println(Arrays.toString(sol.generate(5).toArray()));
    }

    public static void main8(String[] args) {
        BinarySearch.Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static void main7(String[] args) {
        dp.Solution sol = new dp.Solution();
        System.out.println(sol.jump(new int[]{2, 3, 1, 1, 4}));

    }

    public static void main6(String[] args) {
        BinarySearch.Solution sol = new Solution();
        System.out.println(sol.nextGreatestLetter(new char[]{'a', 'b', 'c'}, 'b'));
    }

    public static void main5(String[] args) {
        structure.Solution sol = new structure.Solution();
        System.out.println(Arrays.toString(sol.intersect(new int[]{1, 1, 2, 3, 4}, new int[]{1, 1, 4, 5})));
        System.out.println();
    }

    public static void main4(String[] args) {
        BinarySearch.Solution sol = new Solution();
        System.out.println(sol.isPerfectSquare(16));
    }

    public static void main3(String[] args) {
        structure.Solution solution = new structure.Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{1, 4, 6, 8, 9}, 10)));

    }

    public static void main2(String[] args) {
        dp.Solution solution = new dp.Solution();
        System.out.println(solution.minCostClimbingStairs2(new int[]{1, 3, 5, 2}));
    }

    public static void main1(String[] args) {
        dp.Solution solution = new dp.Solution();
        System.out.println(solution.deleteAndEarn(new int[]{1, 10, 2, 5, 5, 3}));
    }

}
