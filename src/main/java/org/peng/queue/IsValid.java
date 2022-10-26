package org.peng.queue;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。
        示例 1:
        输入: "()"
        输出: true
        示例 2:
        输入: "()[]{}"
        输出: true
        示例 3:
        输入: "(]"
        输出: false
        示例 4:
        输入: "([)]"
        输出: false
        示例 5:
        输入: "{[]}"
        输出: true*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class IsValid {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        Deque<Character> deque = new ArrayDeque<>();

        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deque.addFirst(')');
            } else if (c == '{') {
                deque.addFirst('}');
            } else if (c == '[') {
                deque.addFirst(']');
            } else if (deque.isEmpty() || deque.getFirst() != c) {
                return false;
            } else {
                deque.removeFirst();
            }
        }
        return deque.isEmpty();
    }
}
