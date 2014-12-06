/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
//从表头开始一个个比较下去，遇到相等的指向下一个；遇到不等的，更新要比较的节点，开始新一轮比较
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        while(cur.next!=null){
            ListNode temp=cur.next;
            while(temp!=null&&cur.val==temp.val){  //只要相等就指向下一个节点
                cur.next=temp.next;
                temp=temp.next;
            }
            if(cur.next!=null){  //注意判断cur是否是最后个元素
                cur=cur.next;    //取下一个元素开始下轮比较
            }
        }
        return head;
    }
}

//利用双指针的思想，一个指向当前不重复的最后一个元素，一个进行依次扫描，遇到不重复的则更新第一个指针，继续扫描，否则就把前面指针指向当前元素的下一个（即把当前元素从链表中删除）。时间上只需要一次扫描，所以是O(n)，空间上两个额外指针，是O(1)
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode pre=head;  //要比较的节点
        ListNode cur=head.next;
        while(cur!=null){
        	if(cur.val==pre.val){
        		pre.next=cur.next;
        	}else{
        		pre=cur;   //若不等，更新要比较的节点
        	}
        	cur=cur.next;
        }
        return head;
    }
}