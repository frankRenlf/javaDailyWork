package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : leetcode2022_6_14
 * @Package : leetcode
 * @createTime : 2022/6/14 15:20
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ret.add((int) (((long) ret.get(i - 1) * (rowIndex - i + 1)) / i));
        }
        return ret;
    }

}
