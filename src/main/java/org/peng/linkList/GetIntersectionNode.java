package org.peng.linkList;

/*给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

        图示两个链表在节点 c1 开始相交：
        注意：只要有相同内存空间即可*/

/**
 * Create by peng on 2022/10/24.
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            if (curA != null) {
                curA = curA.next;
            } else {
                curA = headB;
            }
            if (curB != null) {
                curB = curB.next;
            } else {
                curB = headA;
            }
        }
        return curA;
    }
}
