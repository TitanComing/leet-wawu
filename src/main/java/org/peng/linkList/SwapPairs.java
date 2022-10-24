package org.peng.linkList;

/**
 * Create by peng on 2022/10/24.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next;
            prev.next = head.next; //1.虚拟节点转换
            head.next.next = head; //2.后一个节点反向
            head.next = temp;      //3.head节点指向后续
            prev = head;
            head = head.next;
        }
        return dummyNode.next;
    }
}
