import leetcode.Solution;
import org.w3c.dom.ls.LSOutput;


public class App {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("0P"));
    }

    public static void main2(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.retLen("I'm frank Ren"));
    }

    public static void main1(String[] args) {
        Solution sol = new Solution();
        String s = "abacadc";
        System.out.println(sol.firstUniqChar(s));
    }

}
