package nowcoder;

/**
 * <p>一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * <p>数据范围：0≤n≤40
 * <p>要求：时间复杂度：O(n) ，空间复杂度： O(1)
 */
public class NC68 {
    public static void main(String[] args) {
        System.out.println(jumpFloor(6));
    }

    private static int jumpFloor(int target){
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        return jumpFloor(target-1) + jumpFloor(target-2);
    }
}
