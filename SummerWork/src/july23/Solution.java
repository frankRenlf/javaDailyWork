package july23;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : july23
 * @createTime : 2022/7/23 17:16
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (slow != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
    }

    public boolean isUgly(int n) {
        int[] elem = new int[]{2, 3, 5};
        while (n != 1) {
            int i = 0;
            for (; i < elem.length; i++) {
                if (n % elem[i] == 0) {
                    n /= elem[i];
                    break;
                }
            }
            if (i == elem.length) {
                return false;
            }
        }
        return true;
    }

}
