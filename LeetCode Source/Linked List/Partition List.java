/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

//先找出第一个大于或等于x的节点的前一个节点，然后利用双指针，pre指在前面都是小于x的最后一个节点，cur向后移动扫描，若大于或等于x的cur下移一位，若小于x的，则移动到pre的后面，注意节点之间的衔接（要保留pre、cur、当前节点的的指向变化）
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
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fakeHead=new ListNode(-1);
        fakeHead.next=head;
        ListNode pre=fakeHead;
        //先找出第一个大于或等于x的节点的前一个节点
        while(pre.next!=null&&pre.next.val<x){     
            pre=pre.next;
        }
        ListNode cur=pre;
        while(cur.next!=null){
            if(cur.next.val<x){
                ListNode tmp=cur.next;  //存储小于目标值的节点的下一节点
                cur.next=tmp.next;      //去除该节点后的衔接处理
                tmp.next=pre.next;
                pre.next=tmp;
                pre=pre.next;
            }else{
                cur=cur.next;
            }
        }
        return fakeHead.next;
    }
}


//方法二

public ListNode partition(ListNode head,int x){
	if(head==null||head.next==null){
		return head;
	}

	ListNode small=new ListNode(-1);
	ListNode smallHead=small;
	ListNode big=new ListNode(-1);
	ListNode bigHead=big;

	while(head!=null){
		if(head.val<x){
			small.next=head;
			small=small.next;
		}else{
			big.next=head;
			big=big.next;
		}
		head=head.next;
	}
	big.next=null;
	small.next=bigHead.next;
	return smallHead.next;
}