package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_7_7
 * @Package : leetcode
 * @createTime : 2022/7/7 15:19
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<String>(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    words[i] = word.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }


    List<String> ret = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return ret;
        }
        getParenthesis("", n, n);
        return ret;
    }

    private void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            ret.add(str);
            return;
        }
        if (left == right) {
            getParenthesis(str + "(", left - 1, right);
        }
        if (left < right) {
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }
    }

}
