package com.leetcode.stackandqueue;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyQueue232 {
    Stack<Integer> inputStack, outputStack;
    /**
     * Initialize your data structure here.
     */
    public MyQueue232() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inputStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //先清空output栈
        while (!outputStack.empty()){
            outputStack.pop();
        }
        //把当前的input栈所有元素压如output栈
        while (!inputStack.empty()){
            outputStack.push(inputStack.pop());
        }
        //弹出outpu栈的栈顶元素，也就是队列的首元素，队列弹出之后，元素不存在队列中，因此top元素不需要往input栈中放
        int top = outputStack.pop();
        //将output栈中的所有元素，除了被弹出的栈顶元素之外的元素，压回input栈
        while (!outputStack.empty()){
            inputStack.push(outputStack.pop());
        }
        return top;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        //清空output栈
        while (!outputStack.empty()){
            outputStack.pop();
        }
        //将input栈中的元素压如output栈
        while (!inputStack.empty()){
            outputStack.push(inputStack.pop());
        }
        //拿到栈顶元素的值，不弹出
        int peek = outputStack.peek();
        //把output栈中的元素再压回input栈
        while (!outputStack.empty()){
            inputStack.push(outputStack.pop());
        }
        return peek;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inputStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
