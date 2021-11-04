package utils;

import data.DoubleLinkNode;
import data.LinkNode;
import data.ListNode;

public class Printer {
    public static void print(int[] arrs){
        if (arrs == null){
            System.out.println("null");
            return;
        }
        if (arrs.length == 0){
            System.out.println("[ ]");
            return;
        }
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < arrs.length; i++) {
            if (i < arrs.length-1){
                sb.append(arrs[i]).append(", ");
            }else {
                sb.append(arrs[i]);
            }
        }
        sb.append(" ]");
        System.out.println(sb);
    }

    public static void print(String[] arrs){
        if (arrs == null){
            System.out.println("null");
            return;
        }
        if (arrs.length == 0){
            System.out.println("[ ]");
            return;
        }
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < arrs.length; i++) {
            if (i < arrs.length-1){
                sb.append(arrs[i]).append(", ");
            }else {
                sb.append(arrs[i]);
            }
        }
        sb.append(" ]");
        System.out.println(sb);
    }

    public static <T> void printLink(LinkNode<T> head){
        if (head == null){
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.value).append(" -> ");
            head = head.next;
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static void printLink(ListNode head){
        if (head == null){
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.value).append(" -> ");
            head = head.next;
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static <T> void printDoubleLink(DoubleLinkNode<T> head){
        if (head == null){
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.value).append(" -> ");
            head = head.next;
        }
        sb.append("null");
        System.out.println(sb);
    }
}
