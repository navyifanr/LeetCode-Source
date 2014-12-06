/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

//利用快慢指针的思想，快指针先走n步，然后同时走，快指针到终点时停止。注意头节点的处理，如1->2->null, n=2, 返回2->null

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(n-->0){
            fast=fast.next;
        }
        if(fast==null){        //判断fast是否到终点了
            return slow.next;
        }
        while(fast.next!=null){ //注意这里，fast肯定就不能为null,所以前面要处理null的情况
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}