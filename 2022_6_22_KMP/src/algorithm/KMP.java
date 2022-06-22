package algorithm;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_6_22_KMP
 * @Package : algorithm
 * @createTime : 2022/6/22 10:40
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class KMP {

    // optimize next array
    private void nextVal(String sub, int[] next) {
        for (int i = 1; i < sub.length(); i++) {
            if (sub.charAt(i) == sub.charAt(next[i])) {
                next[i] = next[next[i]];
            }
        }
    }

    //create next array
    private void Next(String sub, int[] next) {
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int i = 2;
        while (i < sub.length()) {
            if (k == -1 || sub.charAt(i - 1) == sub.charAt(k)) {
                next[i] = k + 1;
                i++;
                k++;
            } else {
                k = next[k];
            }
        }
    }

    // main kmp method
    public int kmp(String str, String sub, int pos) {
        if (str == null || sub == null) return -1;
        int lenStr = str.length(), lenSub = sub.length();
        if (lenStr == 0 || lenSub == 0) return -1;
        if (pos < 0 || pos >= lenStr) return -1;

        int[] next = new int[lenSub];
        Next(sub, next);
        System.out.println(Arrays.toString(next));
        nextVal(sub, next);
        System.out.println(Arrays.toString(next));
        int i = pos, j = 0;
        while (i < lenStr) {
            if (j == -1 || str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
                if (j == lenSub) {
                    return i - j;
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }

}
