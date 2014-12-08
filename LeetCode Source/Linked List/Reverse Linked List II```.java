/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

/*
分为两个步骤，第一步是找到m结点所在位置，第二步就是进行反转直到n结点。
反转的方法就是每读到一个结点，把它插入到m结点前面位置，然后m结点接到读到结点的下一个。总共只需要一次扫描，
所以时间是O(n)，只需要几个辅助指针，空间是O(1)
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	/*if(head==null){
    		return null;
    	}*/
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode preNode=dummy;
        int i=1;
        while(preNode.next!=null&&i<m){
        	preNode=preNode.next;
        	i++;
        }
        /*if(i<m){
        	return head;
        }*/
        ListNode mNode=preNode.next;
        ListNode cur=mNode.next;
        while(cur!=null&&i<n){
        	ListNode next=cur.next;
        	cur.next=preNode.next;
        	preNode.next=cur;
        	mNode.next=next;
        	cur=next;
        	i++;
        }
        return dummy.next;
    }
}