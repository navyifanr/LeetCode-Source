/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

//题目要求交换每两个相邻的节点。同样利用一个前驱指针fakeHead指向原指针头，防止丢链，用两个指针，pre始终指向需要交换的pair的前面一个node，cur始终指向需要交换的pair的第一个node，逐个交换即可
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
        ListNode fakeHead=new ListNode(-1);
        fakeHead.next=head;
        ListNode pre=fakeHead;
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            ListNode temp=cur;
            cur=cur.next;
            temp.next=cur.next;
            cur.next=temp;           //此处pre、cur同指向temp，即temp是交点
            pre.next=cur;            //修改pre指向
            cur=cur.next.next;       //cur移向下个相邻点
            pre=pre.next.next;       //pre移到下个相邻点前一个节点
        }
        return fakeHead.next;
    }
}

//简洁的递归解法
ListNode swapPairs(ListNode head){
	if(head==null||head.next==null){
		return head;
	}
	ListNode nextPair=head.next.next;
	ListNode newHead=head.next;
	head.next.next=head;
	head.next=swapPairs(nextPair);
	return newHead;
}