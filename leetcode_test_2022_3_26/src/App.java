class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] stacks = new int[len];
        int top=-1;
        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') {
                stacks[++top] = c;
            } else {
                if (top == -1 || (c == ')' && stacks[top] != '(') || (c == '}' && stacks[top] != '{') || (c == ']' && stacks[top] != '[')) {
                    return false;
                }
                top--;
            }
        }
        return top==-1;
    }
}

public class App{
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "({[]})";
        System.out.println(sol.isValid(s));

    }
}