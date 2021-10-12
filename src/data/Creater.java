package data;

public class Creater {

    public static LinkNode<Integer> createLink(){
        LinkNode<Integer> node5 = new LinkNode<>(5, null);
        LinkNode<Integer> node4 = new LinkNode<>(4, node5);
        LinkNode<Integer> node3 = new LinkNode<>(3, node4);
        LinkNode<Integer> node2 = new LinkNode<>(2, node3);
        LinkNode<Integer> node1 = new LinkNode<>(1, node2);
        return node1;
    }

    public static LinkNode<Integer> createCircleLink(){
        LinkNode<Integer> node5 = new LinkNode<>(5, null);
        LinkNode<Integer> node4 = new LinkNode<>(4, node5);
        LinkNode<Integer> node3 = new LinkNode<>(3, node4);
        LinkNode<Integer> node2 = new LinkNode<>(2, node3);
        LinkNode<Integer> node1 = new LinkNode<>(1, node2);
        node5.next = node1;
        return node1;
    }

}
