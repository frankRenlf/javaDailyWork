import summerWork.july.july725.Solution;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : PACKAGE_NAME
 * @createTime : 2022/7/22 12:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Test {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(0);
//        CBTInserter cbtInserter = new CBTInserter(root);
//        System.out.println(cbtInserter.insert(1));
//        System.out.println(cbtInserter.insert(2));
//        System.out.println(root);
//        System.out.println(cbtInserter.insert(3));

        summerWork.july.july725.Solution sol = new Solution();
        System.out.println(sol.searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public static void main725(String[] args) {
        summerWork.july.july24.Solution sol = new summerWork.july.july24.Solution();
        System.out.println(sol.addDigits(38));
    }

    public static void main723(String[] args) {
        summerWork.july.july23.Solution sol = new summerWork.july.july23.Solution();
        System.out.println(sol.isUgly(11));
    }

}
