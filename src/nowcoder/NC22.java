package nowcoder;

import utils.Printer;

/**
 * <p>给出一个整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
 *
 * <p>数据范围： 0≤n,m≤100，|Ai| <=100, |B_i| <= 100
 *
 * <p>注意：
 * <p>1.保证 A 数组有足够的空间存放 B 数组的元素， A 和 B 中初始的元素数目分别为 m 和 n，A的数组空间大小为 m+n
 * <p>2.不要返回合并的数组，将数组 B 的数据合并到 A 里面就好了
 * <p>3. A 数组在[0,m-1]的范围也是有序的
 * <p>示例1
 * <p>输入：
 * <p>[4,5,6],[1,2,3]
 *
 * <p>返回值：
 * <p>[1,2,3,4,5,6]
 *
 * <p>说明：
 * <p>A数组为[4,5,6]，B数组为[1,2,3]，后台程序会预先将A扩容为[4,5,6,0,0,0]，B还是为[1,2,3]，m=3，n=3，传入到函数merge里面，然后请同学完成merge函数，将B的数据合并A里面，最后后台程序输出A数组
 * <p>示例2
 * <p>输入：
 * <p>[1,2,3],[2,5,6]
 * <p>[1,2,3,0,0,0]
 *
 * <p>返回值：
 * <p>[1,2,2,3,5,6]
 */
public class NC22 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        int[] nums3 = {1, 5, 8, 0, 0, 0};
        int[] nums4 = {2, 4, 7};
        merge2(nums3, 3, nums4, 3);
        Printer.print(nums1);
        Printer.print(nums3);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] result = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2];
                p2++;
            } else if (p2 == n) {
                cur = nums1[p1];
                p1++;
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1];
                p1++;
            } else {
                cur = nums2[p2];
                p2++;
            }
            result[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    private static void merge2(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1, len = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]){
                nums1[len] = nums1[p1];
                p1--;
            }else{
                nums1[len] = nums2[p2];
                p2--;
            }
            len--;
        }
    }
}
