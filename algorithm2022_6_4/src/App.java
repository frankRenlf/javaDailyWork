import dp.Solution;

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
        dp.Solution solution = new dp.Solution();
        System.out.println(solution.maxSubArray(new int[]{1, 3, 5, -10, 2}));
    }

}
