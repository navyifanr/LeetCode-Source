/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
//利用分治的思想把合并k个链表分成两个合并k/2个链表的任务，一直划分，知道任务中只剩一个链表或者两个链表。可以很简单的用递归来实现。因此算法复杂度为T(k) = 2T(k/2) + O(nk),很简单可以推导得到算法复杂度为O（nklogk）
public ListNode mergeKLists(List<ListNode> lists){
	int n=lists.size();
	if(n==0){
		return null;
	}
	while(n>1){
		int k=(n+1)/2;
		for(int i=0;i<n/2;i++){
			lists.set(i,merge(lists.get(i),lists.get(i+k)));      //List.set(index, Element)
		}
		n=k;                //修改n值
	}
	return lists.get(0);
}

private ListNode merge(ListNode l1,ListNode l2){
	ListNode fakeHead=new ListNode(-1);
	ListNode l3=fakeHead;                //
	if(l1!=null||l2!=null){
		while(l1!=null&&l2!=null){
			if(l1.val<l2.val){
				l3.next=l1;
				l1=l1.next;
				l3=l3.next;
			}else{
				l3.next=l2;
				l2=l2.next;
				l3=l3.next;
			}
		}
		if(l1!=null){
			l3.next=l1;
		}
		if(l2!=null){
			l3.next=l2;
		}
	}
	return fakeHead.next;
}


//方法2
//先1、2合并，12结果和3合并，123结果和4合并，…,123..k-1结果和k合并
//merge sort,外面套一层循环即可。超时。时间复杂度是O(n*(k^2+k-2)/2) = O(nk^2)
public ListNode mergeKLists(List<ListNode> lists){
	ListNode fakeHead=new ListNode(-1);
	for(int i=0,len=lists.size();i<len;i++){
		ListNode p1=fakeHead.next;
		ListNode p2=lists.get(i);
		ListNode pre=fakeHead;              //pre作为合并后的
		while(p1!=null&&p2!=null){
			if(p1.val<p2.val){
				pre.next=p1;
				p1=p1.next;
			}else{
				pre.next=p2;
				p2=p2.next;
			}
			pre=pre.next;
		}
		if(p1!=null){
			pre.next=p1;
		}
		if(p2!=null){
			pre.next=p2;
		}
	}
	return fakeHead.next;
}


//超时
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size()==0){
        	return null;
        }
        if(lists.size()==1){
        	return lists.get(0);
        }
        ListNode tmp=merge(lists.get(0),lists.get(1));
        for(int i=2,len=lists.size();i<len;i++){
        	tmp=merge(tmp,lists.get(i));
        }
        return tmp;
    }

    public ListNode merge(ListNode l1,ListNode l2){
    	ListNode fakeHead=new ListNode(-1);
    	ListNode l3=fakeHead;                //注意
    	if(l1!=null||l2!=null){
    		while(l1!=null&&l2!=null){
    			if(l1.val<l2.val){
    				l3.next=l1;
    				l1=l1.next;
    				l3=l3.next;
    			}else{
    				l3.next=l2;
    				l2=l2.next;
    				l3=l3.next;
    			}
    		}
    		if(l1!=null){
    			l3.next=l1;
    		}
    		if(l2!=null){
    			l3.next=l2;
    		}
    	}
    	return fakeHead.next;
    }
}