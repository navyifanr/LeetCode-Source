/*
Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

*/

/*
遍历第一个链表，计算长度len1, 保存最后一个节点
遍历第二个链表，计算长度len2,同时检查最后一个节点是否相同，不同，则不相交
从头遍历两链表，（若len1>len2）,链表一先遍历len1-len2个节点，之后同时遍历到相同的节点即可
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int len1=0;
        ListNode h1=headA;
        while(h1.next!=null){  //注意是.next
            h1=h1.next;
            len1++;
        }
        int len2=0;
        ListNode h2=headB;
        while(h2.next!=null){
            h2=h2.next;
            len2++;
        }
        ListNode n1=headA;
        ListNode n2=headB;
        if(len1>len2){
            int k=len1-len2;
            while(k-->0){
                n1=n1.next;
            }
        }else{
            int k=len2-len1;
            while(k-->0){
                n2=n2.next;
            }
        }
        /* or
        while(n1!=n2){
			n1=n1.next;
			n2=n2.next;
        }
        return n1;
        */
        while(n1!=null&&n2!=null){
            if(n1==n2){
                return n1;
            }
            n1=n1.next;
            n2=n2.next;
        }
        return null;
    }
}

//leetcode巧妙的解法
public ListNode getIntersectionNode(ListNode headA,ListNode headB){
	if(headA==null||headB==null){
		return null;
	}
	ListNode pA=headA;
	ListNode pB=headB;

	ListNode tailA=null;
	ListNode tailB=null;

	while(true){
		if(pA==null){
			pA=headB;
		}
		if(pB==null){
			pB=headA;
		}
		if(pA.next==null){
			tailA=pA;
		}
		if(pB.next=null){
			tailB=pB;
		}
		//The two links have different tails. So just return null;
		if(tailA!=null&&tailB!=null&&tailA!=tailB){
			return null;
		}

		if(pA==pB){
			return pA;
		}
		pA=pA.next;
		pB=pB.next;
	}
}