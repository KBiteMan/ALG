package data;

public class Creater {

    public static LinkNode<Integer> createLink() {
        LinkNode<Integer> node5 = new LinkNode<>(5, null);
        LinkNode<Integer> node4 = new LinkNode<>(4, node5);
        LinkNode<Integer> node3 = new LinkNode<>(3, node4);
        LinkNode<Integer> node2 = new LinkNode<>(2, node3);
        LinkNode<Integer> node1 = new LinkNode<>(1, node2);
        return node1;
    }

    public static ListNode creatListNode() {
//        ListNode node6 = new ListNode(6, null);
//        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        return node1;
    }

    public static LinkNode<Integer> createDisorderLink() {
        LinkNode<Integer> node5 = new LinkNode<>(1, null);
        LinkNode<Integer> node4 = new LinkNode<>(7, node5);
        LinkNode<Integer> node3 = new LinkNode<>(2, node4);
        LinkNode<Integer> node2 = new LinkNode<>(9, node3);
        LinkNode<Integer> node1 = new LinkNode<>(6, node2);
        return node1;
    }

    public static LinkNode<Integer> createCircleLink() {
        LinkNode<Integer> node5 = new LinkNode<>(5, null);
        LinkNode<Integer> node4 = new LinkNode<>(4, node5);
        LinkNode<Integer> node3 = new LinkNode<>(3, node4);
        LinkNode<Integer> node2 = new LinkNode<>(2, node3);
        LinkNode<Integer> node1 = new LinkNode<>(1, node2);
        node5.next = node1;
        return node1;
    }

    /**
     *          1
     *         / \
     *        2   3
     *        \  / \
     *        4 5   6
     * @return
     */
    public static TreeNode<Integer> createTree() {
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node3 = new TreeNode<>(3, node5, node6);
        TreeNode<Integer> node2 = new TreeNode<>(2, null, node4);
        TreeNode<Integer> node1 = new TreeNode<>(1, node2, node3);
        return node1;
    }

}
