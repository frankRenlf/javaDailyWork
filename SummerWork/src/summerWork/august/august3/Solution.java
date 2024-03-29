package summerWork.august.august3;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : summerWork.august.august3
 * @createTime : 2022/8/3 16:10
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        minStack.push(minStack.isEmpty() ? x : Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(')');
            } else if (x == '{') {
                stack.push('}');
            } else if (x == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != x) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
