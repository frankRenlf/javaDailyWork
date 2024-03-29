package summerWork.august.august9;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : summerWork.august.august9
 * @createTime : 2022/8/9 21:38
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Solution {

    public int minStartValue(int[] nums) {
        int minVal = 0;
        int sum = 0;
        for (int x : nums) {
            sum += x;
            minVal = Math.min(minVal, sum);
        }
        return 1 - minVal;
    }

}
