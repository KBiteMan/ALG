package nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 *
 * 数据范围：0≤∣arr∣≤1000000，0 < arr_i ≤100000
 * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
 * 示例1
 * 输入：
 * [2,3,4,5]
 * 返回值：
 * 4
 * 说明：
 * [2,3,4,5]是最长子数组
 *
 * 示例2
 * 输入：
 * [2,2,3,4,3]
 * 返回值：
 * 3
 * 说明：
 * [2,3,4]是最长子数组
 *
 * 示例3
 * 输入：
 * [9]
 * 返回值：
 * 1
 *
 * 示例4
 * 输入：
 * [1,2,3,1,2,3,2,2]
 * 返回值：
 * 3
 * 说明：
 * 最长子数组为[1,2,3]
 *
 * 示例5
 * 输入：
 * [2,2,3,4,8,99,3]
 * 返回值：
 * 5
 * 说明：
 * 最长子数组为[2,3,4,8,99]
 *
 * 备注：
 * 1≤n≤10^5
 */
public class NC41 {
    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{2,1,3,4}));
        System.out.println(maxLength2(new int[]{2,1,3,4,6}));
    }

    private static int maxLength(int[] arr) {
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (list.contains(arr[j])) {
                    max = Math.max(list.size(), max);
                    list.clear();
                    break;
                } else {
                    list.add(arr[j]);
                }
            }
            max = Math.max(list.size(), max);
        }
        return max;
    }

    private static int maxLength2(int[] arr){
        LinkedList<Integer> queue = new LinkedList<>();
        int max = 0;
        for (int c : arr) {
            while (queue.contains(c)){
                queue.poll();
            }
            queue.add(c);
            max = Math.max(max,queue.size());
        }
        return max;
    }
}
