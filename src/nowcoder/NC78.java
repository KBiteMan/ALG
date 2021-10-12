package nowcoder;

import data.Creater;
import data.LinkNode;
import utils.Printer;

/**
 * 翻转链表
 */
public class NC78 {
    public static void main(String[] args) {
        LinkNode<Integer> link = Creater.createLink();
        Printer.printLink(link);

        LinkNode<Integer> pre = null, back, header = link;
        while (header != null) {
            //此处为断开链路
            back = header.next;
            header.next = pre;
            //此处将pre和header指针移到下一个位置
            pre = header;
            header = back;
        }
        Printer.printLink(pre);
    }
}
