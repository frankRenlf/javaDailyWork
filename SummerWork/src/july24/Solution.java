package july24;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : july24
 * @createTime : 2022/7/24 14:39
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public int addDigits(int num) {
        while (num / 10 > 0) {
            int tmp = num;
            int sum = 0;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits_Math(int num) {
        return (num - 1) % 9 + 1;
    }

}
