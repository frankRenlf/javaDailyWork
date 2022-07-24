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

    private int guess(int num) {
        int key = 10;
        return Integer.compare(key, num);
    }

    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == -1) {
                right = mid - 1;
            } else if (guess(mid) == 0) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int guessNumber2(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == -1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
