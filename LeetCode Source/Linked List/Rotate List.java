/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

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
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        int size=1;
        while(cur.next!=null){
            cur=cur.next;
            size++;
        }
        cur.next=head;
        int step=size-n%size;            //注意是循环右移，所以要n%size
        if(step==1){
            ListNode tempHead=head.next;
            head.next=null;
            return tempHead;
        }
        ListNode tail=head;
        while(step-->1){
            tail=tail.next;
        }
        ListNode tempHead=tail.next;
        tail.next=null;
        return tempHead;
    }
}


//简洁版
public ListNode rotateRight(ListNode head,int k){
	if(head==null||k==0){
		return head;
	}
	int len=1;
	ListNode cur=head;
	while(cur.next!=null){
		cur=cur.next;
		len++;
	}
	k=len-k%len;
	cur.next=head;
	int step=0;
	while(step<k){
		cur=cur.next;
		step++;
	}
	head=cur.next;
	cur.next=null;
	return head;
}