package leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int obtain(int[] num, int l, int r) {
        int s = num[l];
        int e = Math.max(num[l], num[l + 1]);
        int tmp = 0;
        for (int i = l + 2; i < r; i++) {
            tmp = e;
            e = Math.max(num[i] + s, e);
            s = tmp;
        }
        return e;
    }

    public int rob(int[] num) {
        int len = num.length;
        if (num == null || len == 0) {
            return 0;
        }
        if (len == 1) {
            return num[0];
        }
        if (len == 2) {
            return Math.max(num[0], num[1]);
        }
        return Math.max(obtain(num, 0, len - 1), obtain(num, 1, len));
    }


    public int deleteAndEarn(int[] num) {
        int len = num.length;
        if (num == null || len == 0) {
            return 0;
        }
        if (len == 1) {
            return num[0];
        }
        int maxN = 0;
        for (int x : num) {
            maxN = Math.max(x, maxN);
        }
        int[] sum = new int[maxN + 1];
        for (int x : num) {
            sum[x] += x;
        }
        return count(sum);
    }

    public int count(int[] sum) {
        int len = sum.length;
        int s = sum[0];
        int e = Math.max(s, sum[1]);
        int tmp = 0;
        for (int i = 2; i < len; i++) {
            tmp = e;
            e = Math.max(sum[i] + s, e);
            s = tmp;
        }
        return e;
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSelfDividing(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }


}