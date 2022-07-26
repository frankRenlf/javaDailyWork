package leetcode.july26;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : leetcode.july26
 * @createTime : 2022/7/26 13:59
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    // first method, use hashmap to contain each character
    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if (map.containsKey(x) && map.get(x) >= 1) {
                map.replace(x, map.get(x) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    // second use array to contain
    //65-122
    // second method can avoid the calculation of hash val.
    // but it will have an initiate extra space to create array.
    public boolean CheckPermutation2(String s1, String s2) {
        int[] arr = new int[58];
        for (char x : s1.toCharArray()) {
            arr[x - 'A'] += 1;
        }
        for (char x : s2.toCharArray()) {
            arr[x - 'A'] -= 1;
            if (arr[x - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }


    // next method of new question
    // obviously, it wants us to use priority queue
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int x : stones) {
            queue.add(x);
        }
        while (queue.size() > 1) {
            int s1 = queue.poll();
            int s2 = queue.poll();
            if (s1 != s2) {
                queue.add(Math.abs(s1 - s2));
            }
        }
        return queue.size() == 0 ? 0 : queue.poll();
    }

    // today's work is over

}
