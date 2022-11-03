package org.peng.queue;

/*根据 逆波兰表示法，求表达式的值。

        有效的运算符包括 + ,  - ,  * ,  / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
        说明：
        整数除法只保留整数部分。 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
        示例 1：
        输入: ["2", "1", "+", "3", " * "]
        输出: 9
        解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
        示例 2：
        输入: ["4", "13", "5", "/", "+"]
        输出: 6
        解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6*/

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                deque.addFirst(deque.removeFirst() + deque.removeFirst());
            } else if ("-".equals(token)) {
                //减法先出栈是被减数，后出栈是减数
                deque.addFirst(-deque.removeFirst() + deque.removeFirst());
            } else if ("*".equals(token)) {
                deque.addFirst(deque.removeFirst() * deque.removeFirst());
            } else if ("/".equals(token)) {
                //除法除数和被除数出栈顺序
                int divide1 = deque.removeFirst(); //除数
                int divide2 = deque.removeFirst(); //被除数
                deque.addFirst(divide2 / divide1);
            } else {
                deque.addFirst(Integer.valueOf(token));
            }
        }
        return deque.getFirst();
    }
}
