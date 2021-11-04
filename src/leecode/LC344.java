package leecode;

import utils.Printer;

public class LC344 {
    public static void main(String[] args) {
        String[] s = {"A", " ", "m", "a", "n", "ss", " ", "a", " ", "p", "l", "a", "n", "ss", " ", "a", " ", "c", "a", "n", "a", "l", ":", " ", "P", "a", "n", "a", "m", "a"};
        String[] s2 = {"a", "m", "a", "n", "a", "P", " ", ":", "l", "a", "n", "a", "c", " ", "a", " ", "ss", "n", "a", "l", "p", " ", "a", " ", "ss", "n", "a", "m", " ", "A"};
        reverseString(s);
        Printer.print(s);
        Printer.print(s2);
    }

    public static void reverseString(String[] s) {
        int size = s.length;
        int mid = size / 2;
        for (int i = 0; i < mid; i++) {
            String temp = s[i];
            s[i] = s[size - 1 - i];
            s[size - 1 - i] = temp;
        }

    }
}
