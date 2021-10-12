package nowcoder;

import data.Constants;

/**
 * <p>请实现有重复数字的升序数组的二分查找
 * <p>给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的第一个出现的target，如果目标值存在返回下标，否则返回 -1
 *
 * <p>示例1
 * <p>输入：
 * <p>[1,2,4,4,5],4
 *
 * <p>返回值：
 * <p>2
 *
 * <p>说明：
 * <p>从左到右，查找到第1个为4的，下标为2，返回2
 * <p>示例2
 * <p>输入：
 * <p>[1,2,4,4,5],3
 *
 * <p>返回值：
 * <p>-1
 *
 * <p>示例3
 * <p>输入：
 * <p>[1,1,1,1,1],1
 *
 * <p>返回值：
 * <p>0
 */
public class NC105 {
    public static void main(String[] args) {
        System.out.println("1: "+search(Constants.INTS1,2));
        System.out.println("2: "+search(Constants.INTS2,1));
        System.out.println("3: "+search(Constants.INTS3,3));
        System.out.println("4: " + search(Constants.INTS4, 2));
    }

    private static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                while (mid > 0) {
                    if (nums[mid - 1] == target) {
                        mid -= 1;
                    } else {
                        break;
                    }
                }
                return mid;
            }
        }
        return -1;
    }
}
