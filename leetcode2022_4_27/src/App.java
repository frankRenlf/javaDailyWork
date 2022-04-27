import leetcode.Solution;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Character> ret = sol.test("hello bit", "come");
        for (char c : ret) {
            System.out.print(c);
        }
        System.out.println();
    }

}
