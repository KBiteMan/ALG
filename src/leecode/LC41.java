package leecode;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC41 {
    public static void main(String[] args) {
        System.out.println(minNumberDisappeared(new int[]{1,0,2})+" ==== 3");
        System.out.println(minNumberDisappeared(new int[]{-2,3,4,1,5})+" ==== 2");
        System.out.println(minNumberDisappeared(new int[]{4,5,6,8,9})+" ==== 1");
    }

    public static int minNumberDisappeared (int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE,max = 0;
        for(int i = 0; i < length; i++){
            int v = nums[i];
            if(v > 0){
                if(v - max > 1 && i != 0 ){
                    return v - 1;
                }
                if(min > v){
                    min = v;
                }
                if(max < v){
                    max = v;
                }
            }
        }
        if(min > 1){
            return 1;
        }
        return max+1;
    }
}
