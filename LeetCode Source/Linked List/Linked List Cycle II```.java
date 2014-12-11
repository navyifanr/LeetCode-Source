/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
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
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        //错误检查，这是无环情况
		if(fast==null||fast.next==null){
			return null;
		}
		//相遇点离环开始点和链表头到环开始点距离一样，将slow置于表头，fast不变，两者再次相遇就是环的开始点
        slow=head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}



//错误思路！！！并不是相遇点的下一个节点就是开始点（以下错误）
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        boolean flag=false;
        ListNode temp=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                flag=true;
                temp=fast;
            }
        }
        if(flag){
            fast=head;
            while(fast.val!=temp.val){
                fast=fast.next;
            }
            return fast;
        }
        return null;
    }
}