package leetcode.july725;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : SummerWork
 * @Package : leetcode.july725
 * @createTime : 2022/7/25 13:52
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */


public class Solution {

    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //
    //请必须使用时间复杂度为 O(log n) 的算法。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/search-insert-position
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //需要找到目标值,或者插入位置.
    //意思是找到小于等于val的数据位置.
    //关键是小于等于,这个决定了我们的判断条件
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 因为nums[left]<=target
        return left;
    }

    // 刚开始是正确的,后面是错误的.
    //也就是说要找到第一个错误的,得将判断条件改为!
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
