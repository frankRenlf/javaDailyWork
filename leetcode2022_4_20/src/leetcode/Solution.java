package leetcode;

import java.util.Arrays;

public class Solution {

    //    public int specialArray(int[] nums) {
//        int l =0;
//        int re = nums.length-1;
//        int r= re;
//        while(l<r){
//            int x = re-r;
//            if(nums[r]>=x)
//
//        }
//
//    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            int x = matrix[mid / n][mid % n];
            if (x > target) {
                r = mid - 1;
            } else if (x == target) {
                return true;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length;
        while(l<r){
            if()
        }
    }

}
