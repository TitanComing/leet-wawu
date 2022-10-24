package org.peng.linkList;

/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

        进阶：你能尝试使用一趟扫描实现吗？*/

import java.util.LinkedList;

/**
 * Create by peng on 2022/10/24.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode slowIndex = dummyNode;
        ListNode fastIndex = dummyNode;

        for (int i = 0; i < n; i++) {
            fastIndex = fastIndex.next;
        }
        while (fastIndex.next != null){
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next;
        }

        slowIndex.next = slowIndex.next.next;

        return dummyNode.next;
    }
}
