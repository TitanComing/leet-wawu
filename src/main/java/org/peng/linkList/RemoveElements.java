package org.peng.linkList;

/*题意：删除链表中等于给定值 val 的所有节点。

        示例 1：
        输入：head = [1,2,6,3,4,5,6], val = 6
        输出：[1,2,3,4,5]

        示例 2：
        输入：head = [], val = 1
        输出：[]

        示例 3：
        输入：head = [7,7,7,7], val = 7
        输出：[]*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        //头节点
        while (head != null && head.val == val){
           head =  head.next;
        }
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while (cur != null){
            while (cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;

    }
}
