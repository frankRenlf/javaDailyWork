package summerWork.august.august4;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : summerWork.august.august4
 * @createTime : 2022/8/4 14:15
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        while (size > 0) {
            queue.offer(queue.poll());
            size--;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    private int top;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            top = x;
        }
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return top;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}


public class Solution {

    // 基础类型,比如int[],是不能放比较器的....而且sort只能升序排序
    public List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> ret = new ArrayList<>();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret.add(nums[i]);
            sum += nums[i];
            total -= nums[i];
            if (sum > total) {
                break;
            }
        }
        return ret;
    }

}
