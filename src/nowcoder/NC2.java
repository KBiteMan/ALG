package nowcoder;

import data.Creater;
import data.ListNode;
import utils.Printer;

/**
 * 描述
 * 将给定的单链表 L：0 →L1 →…→Ln−1→Ln
 * 重新排序为：L0→Ln →L1→L{n-1}→L2→L{n-2}→…
 * 要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
 *
 * 数据范围：链表长度 0≤n≤20000 ，链表中每个节点的值满足 0≤val≤1000
 *
 * 要求：空间复杂度 O(n) 并在链表上进行操作而不新建链表，时间复杂度 O(n)
 * 进阶：空间复杂度 O(1) ， 时间复杂度 O(n)
 *
 * 示例1
 * 输入：
 * {1,2,3,4}
 * 返回值：
 * {1,4,2,3}
 * 说明：
 * 给定head链表1->2->3->4, 重新排列为 1->4->2->3,会取head链表里面的值打印输出 1
 *
 * 示例2
 * 输入：
 * {1,2,3,4,5}
 * 返回值：
 * {1,5,2,4,3}
 * 说明：
 * 给定head链表1->2->3->4->5, 重新排列为 1->5>2->4->3,会取head链表里面的值打印输出
 *
 * 示例3
 * 输入：
 * {}
 * 返回值：
 * {}
 */

public class NC2 {

    public static void main(String[] args) {
        ListNode listNode = Creater.creatListNode();
        Printer.printLink(listNode);
        reorderList(listNode);
        Printer.printLink(listNode);
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode newHead = reversal(mid);
//        merge(head,last);
        while(newHead != null){
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    private static void merge(ListNode l1,ListNode l2){
        ListNode p = new ListNode(0);
        while(l1 !=null && l2 != null){
            p.next = l1;
            l1 = l1.next;
            p = p.next;
            p.next = l2;
            l2 = l2.next;
        }
    }

    private static ListNode reversal(ListNode head){
        ListNode pre = null, next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
