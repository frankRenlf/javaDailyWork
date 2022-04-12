package leetcode.frank;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int sum = 10;
        int tmp = 9;
        for (int i = 1; i < n; i++) {
            tmp *= (10 - i);
            sum += tmp;
        }
        return sum;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        for (int x : dp) {
            System.out.println(x);
        }
        return maxans;
    }

//    public int lengthOfLIS2(int[] nums){
//
//        int len = nums.length;
//        for(int i = len-1;i>=0;i--){
//            for(int j = i - 1;j>=0;j--){
//                if()
//            }
//        }
//
//    }

    public int[] numberOfLines(int[] widths, String s) {
        int row = 1;
        int col = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int tmp = col + widths[s.charAt(i) - 'a'];
            if (tmp > 100) {
                col = widths[s.charAt(i) - 'a'];
                row++;
            } else {
                col = tmp;
            }
        }
        return new int[]{row, col};
    }

    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            int an = mid * mid;
            if (an < num) {
                l = mid + 1;
            } else if (an == num) {
                return true;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }


    public int uniquePaths(int m, int n) {
        // long ret = 1;
        // for (int x = n, y = 1; y < m; ++x, ++y) {
        //     ret = ret * x / y;
        // }
        // return (int)ret;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            arr[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] step = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            step[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            step[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                step[i][j] = obstacleGrid[i][j] == 1 ? 0 : step[i - 1][j] + step[i][j - 1];
            }
        }
        return step[m - 1][n - 1];
    }

}
