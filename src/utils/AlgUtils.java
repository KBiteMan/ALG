package utils;

/**
 * 相关工具
 */
public class AlgUtils {
    public static void changeValue(int[] nums, int indexA,int indexB){
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
}
