package BinarySearch;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : algorithm2022_6_4
 * @Package : BinarySearch
 * @createTime : 2022/6/4 13:56
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for (int x : arr1) {
            boolean ok = true;
            for (int y : arr2) {
                ok &= Math.abs(x - y) > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 0;
        int right = num / 2;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >>> 1);
            long square = (long) mid * mid;
            if (square > num) {
                right = mid - 1;
            } else if (square == num) {
                return true;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public int peakIndexInMountainArray(int[] nums) {
        int left = 1;
        int right = nums.length - 2;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return right;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     public int guessNumber(int n) {
     int left = 0;
     int right = n;
     while(left<=right){
     int mid = left+((right-left)>>>1);
     // one method given by leetcode
     if(guess(mid)==-1){
     right=mid-1;
     }else if(guess(mid)==0){
     return mid;
     }else{
     left=mid+1;
     }
     }
     return 0;
     }
     */

}