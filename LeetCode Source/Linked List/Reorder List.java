/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){  //要获取中间节点的前一个元素
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode halfNode=slow.next;
        slow.next=null;                //注意此处要将前半段最后一个元素指向null
        ListNode halfHead=null;
        while(halfNode!=null){
            ListNode pre=halfNode;
            halfNode=halfNode.next;
            pre.next=halfHead;
            halfHead=pre;
        }
        ListNode cur=head;
        while(halfHead!=null){
            ListNode pre=halfHead;
            halfHead=halfHead.next;
            pre.next=cur.next;
            cur.next=pre;
            cur=cur.next.next;       //注意指针要指向隔一个节点
        }
    }
}