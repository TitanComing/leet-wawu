package org.peng.linkList;

/**
 * Create by peng on 2022/10/24.
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //有环
                ListNode index1 = fast;
                ListNode index2 = head;
                //两个指针，从头尾和相约点同步走
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
