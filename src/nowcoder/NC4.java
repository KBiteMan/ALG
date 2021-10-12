package nowcoder;

import data.Creater;
import data.LinkNode;

/**
 * <p>判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 *
 *
 * <p>数据范围：链表长度 0≤n≤10000，链表中任意节点的值满足 |val| <= 100000
 * <p>要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * <p>输入分为2部分，第一部分为链表，第二部分代表是否有环，然后回组成head头结点传入到函数里面。-1代表无环，其他的数字代表有环，这些参数解释仅仅是为了方便读者自测调试。实际在编码时读入的是链表的头节点。
 *
 * <p>示例1
 * <p>输入：
 * <p>{3,2,0,-4},1
 *
 * <p>返回值：
 * <p>true
 *
 * <p>说明：
 * <p>第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1，即-4->2存在一个链接，组成传入的head为一个带环的链表 ,返回true
 */
public class NC4 {
    public static void main(String[] args) {
        LinkNode<Integer> link = Creater.createLink();
        LinkNode<Integer> circleLink = Creater.createCircleLink();

        System.out.println(isCicle(link));
        System.out.println(isCicle(circleLink));
    }

    /**
     * 连个指针比赛遍历比赛，闭环链表总会有相遇的时候
     * @param head
     * @return
     */
    private static boolean isCicle(LinkNode<Integer> head) {
        if (head == null)
            return false;
        LinkNode<Integer> slow = head;
        LinkNode<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
