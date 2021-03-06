package leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_22
 * @Package : leetcode
 * @createTime : 2022/6/22 9:54
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public boolean isSubsequence(String s, String t) {
        int ls = s.length(), lt = t.length();
        int i = 0;
        for (int j = 0; i <= ls && j < lt; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i >= ls;
    }

}
