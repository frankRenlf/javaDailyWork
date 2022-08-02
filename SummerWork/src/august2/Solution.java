package august2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : august2
 * @createTime : 2022/8/2 16:12
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Solution {

    // 大小写没整对
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1, index = 0; i <= n && index < target.length; i++) {
            if (target[index] == i) {
                list.add("Push");
                index++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

}
