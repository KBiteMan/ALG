package data;

/**
 * 双向链表节点
 * @param <T>
 */
public class DoubleLinkNode<T> {
    public DoubleLinkNode<T> pre;
    public DoubleLinkNode<T> next;
    public T value;
    public int key;

    public DoubleLinkNode(DoubleLinkNode<T> pre, int key,T value, DoubleLinkNode<T> next){
        this.pre = pre;
        this.value = value;
        this.next = next;
    }

    public DoubleLinkNode(int key,T value){
        this.value = value;
        this.key = key;
    }
}
