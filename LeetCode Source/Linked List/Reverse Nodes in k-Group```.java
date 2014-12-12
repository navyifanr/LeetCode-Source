/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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

public static ListNode reverseKGroup(ListNode head,int k){
	if(head==null||k==1){
		return head;
	}
	ListNode fakeHead=new ListNode(-1);
	fakeHead.next=head;
	ListNode pre=fakeHead;
	int i=0;
	while(head!=null){
		i++;
		if(i%k==0){           //此处对k取模，判断是不是到达k组的节点
			pre=reverse(pre,head.next);  //reverse返回的last就是pre
			head=pre.next;
		}else{
			head=head.next;
		}
	}
	return fakeHead.next;
}

private static ListNode reverse(ListNode pre,ListNode next){  //区间的链表反转
	ListNode last=pre.next;  //last不变
	ListNode cur=last.next;  //cur移动
	while(cur!=next){
		last.next=cur.next;
		cur.next=pre.next;
		pre.next=cur;
		cur=last.next;
	}
	return last;
}

//超时
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==0||k==1){
            return head;
        }
        ListNode fakeHead=new ListNode(-1);
        fakeHead.next=head;
        ListNode pre=fakeHead;
        ListNode cur=head;
        int n=k;
        while(cur!=null){
            ListNode tail=pre.next;
            ListNode tmp=new ListNode(-1);
            while(cur!=null&&n-->0){
                cur=cur.next;
                tmp.next=cur;
                tmp=tmp.next;
            }
            if(cur==null){
                break;
            }
            tmp=reverse(tmp.next);
            pre.next=tmp;
            tail.next=cur;
            pre=tail;
        }
        return fakeHead.next;
    }
    
    private ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode reHead=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode pre=cur;
            cur=cur.next;
            pre.next=reHead;
            reHead=pre;
        }
        return reHead;
    }
}