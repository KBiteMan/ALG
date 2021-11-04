package leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20 {
    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char w = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == map.get(w)) {
                stack.pop();
            } else {
                stack.push(w);
            }

        }
        return stack.isEmpty();
    }
}
