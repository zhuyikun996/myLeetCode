package com.leetcode.link;

import com.leetcode.common.ListNode;

public class Solution24swapPairs {
    /**
     * 递归解法
     */
    public ListNode swapPairs(ListNode head) {
        //判空：当head为null或者head.next为null时，直接返回head即可
        if (head == null || head.next == null) return head;
        ListNode next = head.next;//next为head的后继节点
        head.next = swapPairs(next.next);//head指向next.next，此处递归
        next.next = head;//next指向head，此时已经调整完成head和next的指向
        return next;
    }

    /**
     * 非递归解法
     */
    public ListNode swapPairsNotRecursion(ListNode head) {
        ListNode pre = new ListNode(0);//辅助节点pre
        pre.next = head;//辅助节点放在head节点前
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {//头节点不为空并且头节点的next节点不为空
            ListNode start = temp.next;//start节点为head节点
            ListNode end = temp.next.next;//end节点为head的next节点
            temp.next = end;//将temp节点指向end节点， 调整temp节点的位置，保证temp节点每次都在需要调整的一对节点之前
            start.next = end.next;//将start节点指向下一次调整的两个节点的第一个位置，也就是当前end的next节点
            end.next = start;
        }
        return pre.next;//pre为辅助节点，位于真实head节点之前，所以此时pre的next节点就是真实的head节点，代表调整后的链表
    }
}
