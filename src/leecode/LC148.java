package leecode;

import data.Creater;
import data.LinkNode;
import utils.Printer;

import java.util.Stack;

/**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC148 {
    public static void main(String[] args) {
        LinkNode<Integer> link = Creater.createDisorderLink();
        Printer.printLink(link);
        LinkNode<Integer> sortInList = sortInList(link);
        Printer.printLink(sortInList);
    }

    public static LinkNode<Integer> sortInList (LinkNode<Integer> head) {
        return sortList(head,null);
    }

    private static LinkNode<Integer> sortList(LinkNode<Integer> head, LinkNode<Integer> tail){
        if(head == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        LinkNode<Integer> slow = head, fast = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        LinkNode<Integer> mid = slow;
        LinkNode<Integer> list1 = sortList(head,mid);
        LinkNode<Integer> list2 = sortList(mid,tail);
        LinkNode<Integer> sorted = merge(list1,list2);
        return sorted;
    }

    private static LinkNode<Integer> merge(LinkNode<Integer> l1, LinkNode<Integer> l2){
        LinkNode<Integer> p = new LinkNode<>(0,null);
        LinkNode<Integer> temp = p, temp1 = l1, temp2 = l2;
        while(temp1 != null && temp2 != null){
            if(temp1.value <= temp2.value){
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return p.next;
    }
}
