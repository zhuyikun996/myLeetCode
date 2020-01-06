package com.leetcode.stackandqueue;

import javax.swing.*;
import java.util.PriorityQueue;

public class KthLargest703 {
    PriorityQueue<Integer> priorityQueue;
    private final int k;
    public KthLargest703(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k);
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }
    public int add(int val) {
        if (priorityQueue.size() <= k){
            priorityQueue.offer(val);
        }else if (val > priorityQueue.peek()) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
