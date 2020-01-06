package com.leetcode.link;

import com.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution142 {
    //借助Set通过判重实现
    public ListNode detectCycle_set(ListNode head) {
        Set<ListNode> mySet = new HashSet<>();//利用set这种数据结构可以排重的特点
        while (head != null && head.next != null) {
            if (mySet.add(head)) {//当set中不存在当前节点，则add操作返回true，已经存在当前元素则返回false
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }

    //双指针法
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;//初始化快慢两个指针
        while (true) {//注意，这里是死循环，两种情况下跳出循环：1.链表中存在环时，2.链表不存在环（快指针走到链表，末尾）
            if (fast == null || fast.next == null) return null;//指针走到链表末尾
            fast = fast.next.next;//快指针一次移动2个节点
            slow = slow.next;//慢指针一次移动1个节点
            if (fast == slow) break;//链表中出现环，快慢指针相遇
        }
        fast = head;//调整快指针到head位置
        while (slow != fast) {//循环条件：快慢指针没有相遇
            slow = slow.next;//移动快慢指针
            fast = fast.next;
        }
        return fast;//当快慢指针相遇时，表示出现环，并且该节点是入环的第一个节点
    }
}
