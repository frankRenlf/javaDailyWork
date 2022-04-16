package leetcode;


public class Solution {

    public int firstUniqChar(String s) {
        int[] arr = new int[123];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (arr[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int retLen(String s) {
        int end = s.length();
        int start = s.lastIndexOf(' ') + 1;
        return end - start;
    }

    public boolean isPalindrome(String s) {
        String s1 = s.toUpperCase();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && (s1.charAt(l) < 65 || s1.charAt(l) > 90)) {
                l++;
            }
            while (l < r && (s1.charAt(r) < 65 || s1.charAt(r) > 90)) {
                r--;
            }
            if (l < r) {
                if (s1.charAt(l) == s1.charAt(r)) {
                    l++;
                    r--;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        int sl=0;
        int tl=0;
        int sr = s.length();
        int tr = t.length();
        while(sl<sr&&tl<tr){
            if(s.charAt(sl)==t.charAt(tl)){
                sl++;
            }
            tl++;
        }
        return sl == sr;
    }

}
