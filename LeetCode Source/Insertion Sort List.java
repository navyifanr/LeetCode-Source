/*
Sort a linked list using insertion sort.
*/

//由于链表无法像数组那样从后往前依次比较插入，只能从前往后了。在链表首部添加一个哨兵可以稍微简化下代码。

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
    public ListNode insertionSortList(ListNode head) {
        ListNode ret = new ListNode(-1);  
        ListNode cur = head;  
        ListNode pre = ret;  
          
        while(cur!=null){  
            ListNode tmp = cur;  
            cur=cur.next;  
            if(pre.next==null){  
                pre.next=tmp;  
                tmp.next=null;  
                pre=ret;  
            }else {  
                while(pre.next!=null&&pre.next.val<tmp.val){  
                    pre=pre.next;  
                }  
                tmp.next=pre.next;  
                pre.next=tmp;  
                pre=ret;  
            }  
        }  
        return ret.next;   
    }
}


//方法二
public class InsertionSortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		// dummy
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;

		ListNode qPre = head;
		ListNode q = head.next;
		while (q != null) {
			ListNode next = q.next;
			if (q.val < qPre.val) {
				ListNode pPre = dummy;
				ListNode p = dummy.next;
				while (!p.equals(q)) {
					if (q.val < p.val) {
						// cut
						qPre.next = next;
						// paste
						q.next = pPre.next;
						pPre.next = q;
						break;
					}
					pPre = p;
					p = p.next;
				}
			} else {
				qPre = q;
			}
			q = next;
		}

		return dummy.next;
	}
}