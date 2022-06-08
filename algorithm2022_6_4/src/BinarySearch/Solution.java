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

    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        /*
        if (left == arr.length - 1) {
            return left + k;
        } else if (left == 0) {
            return k;
        } else {
            return left + k;
        }
         */
        return left + k;
    }

    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if ((long) (mid + 1) * mid > (long) 2 * n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int l = 0, r = nums.length - 1; //二分范围
        while (l < r)                    //查找元素的开始位置
        {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[r] != target) return new int[]{-1, -1}; //查找失败
        int L = r;
        l = 0;
        r = nums.length - 1;     //二分范围
        while (l < r)                    //查找元素的结束位置
        {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return new int[]{L, r};
    }

    private int search2(int[] nums, int t) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public int[] searchRange(int[] nums, int target) {
        int l = search2(nums, target - 1);
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, search2(nums, target) - 1};
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int right = letters.length - 1;
        if (letters[right] <= target) {
            return letters[0];
        }
        int left = 0;
        int mid = 0;
        while (left < right) {
            mid = (right + left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[right];
    }

    public int mySqrt2(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        int mid = left + ((right - left) >>> 1);
        ;
        while (left <= right) {
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid == x / mid) {
                return mid;
            } else {
                left = mid + 1;
            }
            mid = (right + left) / 2;
        }
        return mid;
    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        int mid = left + ((right - left) >>> 1);
        while (left <= right) {
            mid = left + ((right - left) >>> 1);
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid == x / mid) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

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
