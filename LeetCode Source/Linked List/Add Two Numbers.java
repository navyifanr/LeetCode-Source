/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode result=new ListNode(-1);
        ListNode resultHead=result;
        int carry=0;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            carry=0;                        //注意加完后要置为0
            if(sum/10==1){
                carry=1;
                sum=sum%10;
            }
            ListNode temp=new ListNode(sum);
            result.next=temp;
            result=result.next;
            
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=l1.val+carry;    //注意此处还要判断进位
            carry=0;
            if(sum/10==1){
                carry=1;
                sum=sum%10;
            }
            ListNode temp=new ListNode(sum);
            result.next=temp;
            result=result.next;
            
            l1=l1.next;
        }
        while(l2!=null){
            int sum=l2.val+carry;
            carry=0;
            if(sum/10==1){
                carry=1;
                sum=sum%10;
            }
            ListNode temp=new ListNode(sum);
            result.next=temp;
            result=result.next;
            
            l2=l2.next;
        }
        if(carry==1){                        //最后一步也还有判断进位
            result.next=new ListNode(1);
        }
        return resultHead.next;
    }
}


//以上方法(真长真臭，囧)的简化版
public ListNode addTwoNumbers(ListNode l1,ListNode l2){
	ListNode newHead=new ListNode(-1);
	ListNode l3=newHead;
	int carry=0;
	while(l1!=null||l2!=null){   //此处是或
		if(l1!=null){
			carry+=l1.val;
			l1=l1.next;
		}
		if(l2!=null){
			carry+=l2.val;
			l2=l2.next;
		}
		l3.next=new ListNode(carry%10);
		l3=l3.next;
		carry/=10;
	}
	if(carry==1){
		l3.next=new ListNode(1);
	}
	return newHead.next;
}