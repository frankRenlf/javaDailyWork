package leetcode.dynamic;

public class Solution {

    public boolean canJump(int[] num) {
        int len = num.length;
        int most = 0;
        for (int i = 0; i < len; i++) {
            if (i <= most) {
                most = Math.max(i + num[i], most);
                if (most >= len - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }


    public int jump(int[] num) {
        int len = num.length;
        int most = 0;
        int end = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (i <= most) {
                most = Math.max(most, num[i] + i);
                if (i == end) {
                    end = most;
                    cnt++;
                }
            }
        }
        return cnt;
    }


}
