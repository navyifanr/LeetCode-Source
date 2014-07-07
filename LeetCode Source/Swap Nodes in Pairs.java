/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

//构造了一个指向表头的结点，然后把表头当作普通结点直接遍历
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode tmp=new ListNode(0);
        tmp.next=head;
        ListNode p=tmp,q=head,r;
        while(q!=null&&q.next!=null){
            p.next=q.next;
            r=q.next.next;
            p.next.next=q;
            q.next=r;
            p=q;
            q=r;
        }
        return tmp.next;
    }
}