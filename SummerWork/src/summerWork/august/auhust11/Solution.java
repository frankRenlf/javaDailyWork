package summerWork.august.auhust11;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : summerWork.august.auhust11
 * @createTime : 2022/8/11 16:10
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Solution {

    public String reformat(String s) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                s1.append(c);
            } else {
                s2.append(c);
            }
        }
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return "";
        }
        StringBuffer tmp = null;
        if (s1.length() < s2.length()) {
            tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        StringBuilder arr = new StringBuilder();
        int l1 = s1.length();
        int l2 = s2.length();
        int e1 = 0;
        int e2 = 0;
        for (int i = 0; i < s.length(); i++) {
            arr.append(i % 2 == 0 ? s1.charAt(e1++) : s2.charAt(e2++));
        }
        return arr.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reformat("leetcode"));
    }

}
