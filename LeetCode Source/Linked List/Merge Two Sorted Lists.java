/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode mergeHead=null;
        if(l1.val<l2.val){
            mergeHead=l1;
            l1=l1.next;
         //   mergeHead.next=null;  //可要可不要，之后节点会更新
        }else{
            mergeHead=l2;
            l2=l2.next;
          //  mergeHead.next=null;
        }
        ListNode cur=mergeHead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
                cur=cur.next;
             //   cur.next=null;
            }else{
                cur.next=l2;
                l2=l2.next;
                cur=cur.next;
             //   cur.next=null;
            }
        }
        if(l1!=null){
            cur.next=l1;
        }else if(l2!=null){
            cur.next=l2;
        }
        return mergeHead;
    }
}

//利用指针哨兵的简化版
public class Solution{
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		ListNode p1=l1;
		ListNode p2=l2;
		ListNode fakeHead=new ListNode(-1);  //引入一个指针哨兵
		ListNode p=fakeHead;
		while(p1!=null&&p2!=null){
			if(p1.val<p2.val){
				p.next=p1;
				p1=p1.next;
			}else{
				p.next=p2;
				p2=p2.next;
			}
			p=p.next;
		}
		if(p1!=null){
			p.next=p1;
		}
		if(p2!=null){
			p.next=p2;
		}
		return fakeHead.next;
	}
}