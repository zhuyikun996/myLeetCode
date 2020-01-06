package com.leetcode.link;

import com.leetcode.common.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 */
public class Solution141 {
    //快慢指针
    public boolean hasCycle(ListNode head) {
        //极端情况：链表只有一个节点或者为空，直接返回false
        if (head == null || head.next == null) return false;
        //初始化快慢指针
        ListNode slow = head;//慢指针从head节点开始
        ListNode fast = head.next;//快指针从head.next开始
        //由于fast指针处在前边，所以只需要判断fast是否为null 和fast.next是否为null即可
        while (fast != null && fast.next != null) {
            //当fast和fast.next都不为null的时候，快慢指针可以继续往前移动
            slow = slow.next;//慢指针移动1步
            fast = fast.next.next;//快指针移动2步
            //当快慢指针走到一起的时候，证明当前链表中存在环，返回true
            if (slow == fast) {
                return true;
            }
        }
        //当fast或者fast.next移动到末尾，并且都没有遇到快慢指针走到一起的情况，则证明当前链表没有环，返回false
        return false;
    }

}
