package org.peng.queue;

import java.util.Deque;
import java.util.LinkedList;

/*给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
        返回滑动窗口中的最大值。
        进阶：        你能在线性时间复杂度内解决此题吗？*/
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        int len = nums.length - k + 1;
        //存储滑动窗口集合
        int resIndex = 0;
        int[] res = new int[len];

        //初始化队列
        CustomQueue customQueue = new CustomQueue();
        for (int i = 0; i < k; i++) {
            customQueue.add(nums[i]);
        }
        res[resIndex++] = customQueue.peek();

        //处理队列剩下的元素
        for (int i = k; i < nums.length; i++) {
            //这里判断的是出队列元素
            customQueue.poll(nums[i-k]);
            //判断入队列元素
            customQueue.add(nums[i]);
            res[resIndex++] = customQueue.peek();
        }

        return res;
    }

    //内部类，维持可能成为最大值的集合
    static class CustomQueue {
        Deque<Integer> deque = new LinkedList<>();

        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.getFirst()) {
                deque.removeFirst();
            }
        }

        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(val);
        }

        int peek() {
            return deque.getFirst();
        }
    }
}
