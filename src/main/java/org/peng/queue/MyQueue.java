package org.peng.queue;

import java.util.Stack;

/*使用栈实现队列的下列操作：

        push(x) -- 将一个元素放入队列的尾部。
        pop() -- 从队列首部移除元素。
        peek() -- 返回队列首部的元素。
        empty() -- 返回队列是否为空。*/

public class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();   //进入队列
        stackOut = new Stack<>();  //出队列
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.empty();
    }

    //搬运元素，从入站搬运到出栈，通过转换将先入后出转换为先入先出，符合定义
    private void dumpstackIn() {
        if (!stackOut.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }

}
