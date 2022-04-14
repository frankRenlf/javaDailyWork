package leetcode.frank;

public class Solution {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] arr = new int[n][n];
        for(int i =n-1;i>=0;i--){
            arr[i][i]=1;
            for(int j =i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    arr[i][j]=arr[i+1][j-1]+2;
                }else{
                    arr[i][j]=Math.max(arr[i+1][j],arr[i][j-1]);
                }
            }
        }
        return arr[0][n-1];
    }

    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int max = 0;
        for (int[] account : accounts) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp += account[j];
            }
            max = Math.max(max, tmp);
        }
        return max;
    }


}
