package nowcoder;

import java.util.Stack;

/**
 * <p>用两个栈来实现一个队列，完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 *
 * <p>数据范围： n≤1000
 * <p>要求：空间复杂度 O(n) ，时间复杂度 O(1)
 */
public class NC76 {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        push(2);
        push(3);
        pop();
        push(1);
        pop();
        pop();
    }

    /**
     * 先把数据存到第一个栈
     *
     * @param node
     */
    private static void push(int node) {
        stack1.push(node);
    }

    /**
     * 取数据的时候，先判断栈2时候为空，空了就把栈1的数据倒入栈2，这样，栈1中的数据顺序到栈2中就反转了。
     * 
     * @return
     */
    private static int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        Integer pop = stack2.pop();
        System.out.println(pop);
        return pop;
    }
}
