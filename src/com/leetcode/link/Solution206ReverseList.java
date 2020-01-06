package com.leetcode.link;

import com.leetcode.common.ListNode;

/**
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * Definition for singly-linked list.
 *   public class ListNode {
 *       int val;
 *       ListNode next;
 *       ListNode(int x) { val = x; }
 *   }
 */
public class Solution206ReverseList {
    public ListNode reverseList(ListNode head) {
        //初始化prev=null,cur=head
        ListNode prev = null;
        ListNode cur = head;
        //while循环，条件：cur！=null
        while (cur != null){
            ListNode temp = cur.next;//记录cur.next
            cur.next = prev;//翻转指向
            prev = cur;//后移prev
            cur = temp;//后移cur
        }
        return prev;//翻转后prev为调整后链表的头指针
    }
}
