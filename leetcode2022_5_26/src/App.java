import leetcode.Solution;
import leetcode.TreeNode;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_5_26
 * @Package : PACKAGE_NAME
 * @createTime : 2022/5/26 10:52
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30">...</a>
 * @Description :
 */
public class App {


    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);
        String dest = scanner.nextLine();

        TreeNode root = sol.createTree(dest);
        sol.InfixOrder(root);
    }
}
