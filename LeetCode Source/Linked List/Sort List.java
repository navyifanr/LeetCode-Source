/*
Sort a linked list in O(n log n) time using constant space complexity.
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


//归并排序
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }else{
        	//快慢指针找到中间点
        	ListNode fast=head;
        	ListNode slow=head;
        	while(fast.next!=null&&fast.next.next!=null){
        		fast=fast.next.next;
        		slow=slow.next;
        	}
        	fast=slow;             //注意修改fast和slow的值，若当其为一个节点时，就不会调用sortList
        	slow=slow.next;
        	fast.next=null;
        	fast=sortList(head);  //前半段排序
        	slow=sortList(slow);  //后半段排序
        	return mergeArray(fast,slow);
        }
    }

    ListNode mergeArray(ListNode list1,ListNode list2){
    	if(list1==null){
    		return list2;
    	}
    	if(list2==null){
    		return list1;
    	}
    	ListNode mergeList=null;
    	if(list1!=null&&list2!=null){
    		if(list1.val<list.val){
    			mergeList=list1;
    			list1=list1.next;
    			mergeList.next=null;
    		}else{
    			mergeList=list2;
    			list2=list2.next;
    			mergeList.next=null;
    		}
    	}
    	ListNode tempList=mergeList;
    	while(list1!=null&&list2!=null){
    		if(list1.val<list2.val){
    			tempList.next=list1;
    			list1=list1.next;
    			tempList=tempList.next;
    			tempList.next=null;
    		}else{
    			tempList.next=list2;
    			list2=list2.next;
    			tempList=tempList.next;
    			tempList.next=null;
    		}
    	}
    	if(list1!=null){
    		tempList.next=list1;
    	}
    	if(list2!=null){
    		tempList.next=list2;
    	}
    	return mergeList;
    }
}


//冒泡排序，超时
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode cur=head;
        ListNode tail=null;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        cur=head;
        while(--size>0){
            while(cur.next!=null||cur.next!=tail){
                if(cur.val>cur.next.val){
                    int temp=cur.val;
                    cur.val=cur.next.val;
                    cur.next.val=temp;
                    cur=cur.next;
                }
            }
            tail=cur;
            cur=head;
        }
        return head;
    }
}