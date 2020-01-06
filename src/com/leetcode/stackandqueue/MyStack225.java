package com.leetcode.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack225 {
    Queue<Integer> inQueue, outQueue;
    private int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack225() {
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        inQueue.add(x);
        top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (inQueue.size() > 1) {//留最后一个，保证top的值为最后进入队列的
            top = inQueue.poll();
            outQueue.add(top);
        }
        top = inQueue.poll();
        //交换in和out队列，交换之后in队列跟原队列相比少了top
        Queue<Integer> temp = inQueue;
        inQueue = outQueue;
        outQueue = temp;
        return top;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (!inQueue.isEmpty()) {//留最后一个，保证top的值为最后进入队列的
            top = inQueue.poll();
            outQueue.add(top);
        }
        //交换in和out队列，交换之后in队列跟原队列相比少了top
        Queue<Integer> temp = inQueue;
        inQueue = outQueue;
        outQueue = temp;
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return inQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
