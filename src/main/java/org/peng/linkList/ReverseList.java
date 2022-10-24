package org.peng.linkList;


/*反转一个单链表。
        示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL*/

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
