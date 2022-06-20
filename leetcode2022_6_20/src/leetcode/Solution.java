package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_20
 * @Package : leetcode
 * @createTime : 2022/6/20 10:56
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    private static int count(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int l1 = count(s, i, i);
            int l2 = count(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (l > end - start + 1) {
                end = i + l / 2;
                start = i - (l - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

}
