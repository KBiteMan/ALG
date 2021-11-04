package data;

/**
 * 树节点
 *
 * @param <T>
 */
public class TreeNode<T> {
    public TreeNode<T> left;
    public T value;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

}
