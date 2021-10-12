package data;

/**
 * 单向链表节点
 * @param <T>
 */
public class LinkNode<T> {
    public T value;
    public LinkNode<T> next;

    public LinkNode(T value, LinkNode<T> next){
        this.value = value;
        this.next = next;
    }
}
