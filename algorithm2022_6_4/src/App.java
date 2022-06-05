import BinarySearch.Solution;

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
        System.out.println(solution.maxSubArray(new int[]{1, 3, 5, -10, 2}));
    }

}
