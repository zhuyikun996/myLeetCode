package com.leetcode.link;

import com.leetcode.common.ListNode;

public class Solution25reverseKGroup {
    //递归
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    //非递归
    public ListNode reversKGroupNotRecursion(ListNode head, int k) {
        ListNode dummy = new ListNode(0);//初始化一个虚拟头节点，指向head节点
        dummy.next = head;

        ListNode pre = dummy;//初始化一个pre和end节点，用于
        ListNode end = dummy;

        while (end.next != null) {
            //第一步 先移动end节点：移动距离，K
            for (int i = 0; i < k && end != null; i++) end = end.next;//先把end往后移动k个节点
            //第二步 翻转start到end之间的链表
            if (end == null) break;//end判空
            ListNode start = pre.next;//start节点为翻转链表的开始的节点
            ListNode next = end.next;//next节点为 待翻转链表的头节点，记下来会把end的后继指针置空，所以这里要先记录一下未翻转链表的头节点
            end.next = null;//end.next已经指向了next，此时将end的后继指针置空,用于接下来的翻转链表，作为停止条件
            pre.next = reverse(start);//对pre到end节点这一段链表进行翻转
            start.next = next;//start节点后移到未翻转链表段的首节点，此时start节点的作用是后移pre和end的链接节点，通过start节点的后移，pre和end同时后移
            pre = start;//pre移动到未翻转链表段的首节点
            end = pre;//end也调整到未翻转链表段的首节点，用于下一次循环
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;//初始化pre节点为空
        ListNode curr = head;//初始化curr节点为head节点
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


}
